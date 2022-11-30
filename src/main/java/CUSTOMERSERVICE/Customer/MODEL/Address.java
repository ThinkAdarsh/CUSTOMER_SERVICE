package CUSTOMERSERVICE.Customer.MODEL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="address_info")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="address1")
    private String address1;

    @Column(name="address2")
    private String address2;

    @Column(name="addresstype")
    private String type;

    @Column(name="landmark")
    private String landmark;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="country")
    private String country;

    @Column(name="pincode")
    private String pincode;

    @Column(name="created_date")
    @CreationTimestamp
    private Timestamp created_date;

    @Column(name="update_date")
    @UpdateTimestamp
    private Timestamp update_date;

}
