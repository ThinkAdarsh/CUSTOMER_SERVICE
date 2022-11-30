package CUSTOMERSERVICE.Customer.MODEL;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer_info")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "name can not be empty")
    @Column(name="name")

    private String name;

    @Column(name="dob")
    private String dob;

    @Column(name="age")
    private byte age;

    @Column(name="gender")
    private String gender;

    @Column(name="email")
    @NotEmpty(message = "email can not be empty")
    private String email;

    @Column(name="number")
    private String number;

    @Column(name="username")
    @NotEmpty(message = "username can not be empty")
    private String username;

    @Column(name="password")
    @NotEmpty(message = "password can not be empty")
    private String password;

    @Column(name="created_date")
    @CreationTimestamp
    private Timestamp createdDate;

    @Column(name="update_date")
    @UpdateTimestamp
    private Timestamp updateDate;

   //oneTO many Address
    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name="customer_address", referencedColumnName = "id")
    private List<Address> detailsList;



}
