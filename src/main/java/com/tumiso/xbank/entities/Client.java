package com.tumiso.xbank.entities;

import com.tumiso.xbank.auth.entities.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "client_profiles")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
//@DynamicUpdate
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer clientId;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    private String idNumber;

    private String firstName;

    private String middleName;

    private String lastName;

    private String contactNumber;
}
