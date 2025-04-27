package com.tumiso.xbank.services;

import com.tumiso.xbank.dtos.ClientProfileRequest;
import com.tumiso.xbank.dtos.ClientProfileResponse;
import com.tumiso.xbank.entities.Client;

import java.util.List;

public interface ClientProfileService {

    public ClientProfileResponse saveClientProfile(ClientProfileRequest clientProfile);

    public Client updateClientProfile(Integer clientProfileId, ClientProfileRequest updatedProfile);

    public List<Client> getAllClientProfiles();

    public Client getClientProfileById(int clientProfileId);

    public Client getClientProfileByUserAccount(int userAccountId);

}
