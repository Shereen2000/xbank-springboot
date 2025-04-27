package com.tumiso.xbank.services;

import com.tumiso.xbank.dtos.ClientProfileRequest;
import com.tumiso.xbank.dtos.ClientProfileResponse;
import com.tumiso.xbank.entities.Client;
import com.tumiso.xbank.repositories.ClientProfileRepository;
import com.tumiso.xbank.entities.Address;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Objects;

public class ClientProfileServiceImp implements ClientProfileService {

    private final ClientProfileRepository clientProfileRepository;

    public ClientProfileServiceImp(ClientProfileRepository clientProfileRepository) {
        this.clientProfileRepository = clientProfileRepository;
    }

    @Override
    public ClientProfileResponse saveClientProfile(ClientProfileRequest saveProfileRequest) {



        Client profile = Client.builder()
                .clientId(null)
                .user()
                .idNumber(saveProfileRequest.getIdNumber())
                .firstName(saveProfileRequest.getFirstName())
                .middleName(saveProfileRequest.getMiddleName())
                .lastName(saveProfileRequest.getLastName())
                .contactNumber(saveProfileRequest.getContactNumber())
                .build();

        Client savedProfile = clientProfileRepository.save(profile);

        return ClientProfileResponse.builder()
                .clientId(savedProfile.getId())
                .userAccountId(savedProfile.getUserId())
                .idNumber(savedProfile.getIdNumber())
                .firstName(savedProfile.getFirstName())
                .middleName(savedProfile.getMiddleName())
                .lastName(savedProfile.getLastName())
                .contactNumber(savedProfile.getContactNumber())
                .address()
                .build();

    }

    @Override
    public Client updateClientProfile(Integer clientProfileId, ClientProfileRequest updateProfileRequest) {

        Client existingProfile = clientProfileRepository.findById(clientProfileId)
                .orElseThrow(() -> new EntityNotFoundException("Client profile of id:"+clientProfileId+" not found"));

        // Update fields if the new value is not null (and empty where necessary)
        if (updateProfileRequest.getIdNumber() != null && !updateProfileRequest.getIdNumber().isEmpty() &&
        !Objects.equals(updateProfileRequest.getIdNumber(), existingProfile.getIdNumber())) {
            existingProfile.setIdNumber(updateProfileRequest.getIdNumber());
        }

        if (updateProfileRequest.getFirstName() != null && !updateProfileRequest.getFirstName().isEmpty() &&
        !Objects.equals(updateProfileRequest.getFirstName(), existingProfile.getFirstName())) {
            existingProfile.setFirstName(updateProfileRequest.getFirstName());
        }


        if (updateProfileRequest.getLastName() != null && !updateProfileRequest.getLastName().isEmpty() &&
        !Objects.equals(updateProfileRequest.getLastName(), existingProfile.getLastName())) {
            existingProfile.setLastName(updateProfileRequest.getLastName());
        }

        if (updateProfileRequest.getContactNumber() != null && !updateProfileRequest.getContactNumber().isEmpty() &&
         !Objects.equals(updateProfileRequest.getContactNumber(), existingProfile.getContactNumber())) {
            existingProfile.setContactNumber(updateProfileRequest.getContactNumber());
        }

        if (!Objects.equals(updateProfileRequest.getMiddleName(), existingProfile.getMiddleName())) {
            existingProfile.setMiddleName(updateProfileRequest.getMiddleName());
        }












        return null;
    }

    @Override
    public List<Client> getAllClientProfiles() {
        return List.of();
    }

    @Override
    public Client getClientProfileById(int clientProfileId) {
        return null;
    }

    @Override
    public Client getClientProfileByUserAccount(int userAccountId) {
        return null;
    }
}
