package com.tumiso.xbank.auth.services;

import com.tumiso.xbank.auth.entities.RefreshToken;
import com.tumiso.xbank.auth.entities.User;
import com.tumiso.xbank.auth.repositories.RefreshTokenRepository;
import com.tumiso.xbank.auth.repositories.UserAccountRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {
    private final UserAccountRepository userAccountRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenService(UserAccountRepository userAccountRepository, RefreshTokenRepository refreshTokenRepository) {
        this.userAccountRepository = userAccountRepository;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public RefreshToken createRefreshToken(String username)
    {
        User user = userAccountRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found with email: "+username));

        RefreshToken refreshToken = user.getRefreshToken();

        if(refreshToken == null)
        {
            long refreshTokenValidity = 5*60*10000;

            refreshToken = RefreshToken.builder()
                    .refreshToken(UUID.randomUUID().toString())
                    .expirationtime(Instant.now().plusMillis(refreshTokenValidity))
                    .user(user)
                    .build();

            refreshTokenRepository.save(refreshToken);
        }

        return refreshToken;
    }

    public RefreshToken verifyRefreshToken(String refreshToken)
    {
        RefreshToken refToken = refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()-> new RuntimeException("Refresh token not found"));

        if(refToken.getExpirationtime().compareTo(Instant.now())<0)
        {
            refreshTokenRepository.delete(refToken);
            throw new RuntimeException("Refresh token expired");
        }

        return refToken;
    }
}
