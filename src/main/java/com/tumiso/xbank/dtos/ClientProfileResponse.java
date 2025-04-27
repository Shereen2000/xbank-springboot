package com.tumiso.xbank.dtos;

import com.tumiso.xbank.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientProfileResponse {


    private Integer clientId;

    private Integer userAccountId;

    private String idNumber;

    private String firstName;

    private String middleName;

    private String lastName;

    private String contactNumber;

    private Address address;

}
