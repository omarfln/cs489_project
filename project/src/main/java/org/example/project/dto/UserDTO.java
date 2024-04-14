package org.example.project.dto;

import lombok.Data;
import org.example.project.model.Address;

@Data
public class UserDTO {
    private  Long id;
    private  String username;
    private  String firstName;
    private  String lastName;
    private  Address address;
}
