package CUSTOMERSERVICE.Customer.DTO;

import lombok.Data;

@Data
public class AddressDTO {

    private int id;
    private String address1;
    private String address2;
    private String type;
    private String landmark;
    private String city;
    private String state;
    private String country;
    private String pincode;


//    private Timestamp created_date;
//    private Timestamp update_date;
}
