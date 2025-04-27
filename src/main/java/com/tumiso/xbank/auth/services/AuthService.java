package com.tumiso.xbank.auth.services;

import com.tumiso.xbank.auth.entities.User;
import com.tumiso.xbank.auth.entities.UserRole;
import com.tumiso.xbank.auth.repositories.UserAccountRepository;
import com.tumiso.xbank.auth.utils.AuthResponse;
import com.tumiso.xbank.auth.utils.LoginRequest;
import com.tumiso.xbank.auth.utils.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserAccountRepository userAccountRepository;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest registerRequest)
    {
        var user = User.builder()
                .userName(registerRequest.getEmail())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(UserRole.USER)
                .build();

        User savedUser = userAccountRepository.save(user);
        var accessToken = jwtService.generateToken(savedUser);
        var refreshToken =  refreshTokenService.createRefreshToken(savedUser.getEmail());


        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken.getRefreshToken())
                .userName(savedUser.getUsername())
                .build();
    }

    public AuthResponse login(LoginRequest loginRequest)
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        var user = userAccountRepository.findByEmail(loginRequest.getEmail()).orElseThrow(()->
                new UsernameNotFoundException("user not found"));

        var accessToken = jwtService.generateToken(user);
        var refreshToke = refreshTokenService.createRefreshToken(loginRequest.getEmail());

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToke.getRefreshToken())
                .userName(user.getUsername())
                .build();
    }
}
