package CUSTOMERSERVICE.Customer.DTO;

import lombok.Data;
 import CUSTOMERSERVICE.Customer.MODEL.Address;

import java.util.List;


@Data
public class CustomerDTO {

    private long id;
    private String name;
    private String dob;
    private byte age;
    private String gender;
    private String email;
    private String number;
    private String username;
    private String password;
    private List<AddressDTO> addressDTOList;
}
