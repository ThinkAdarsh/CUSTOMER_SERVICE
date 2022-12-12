package CUSTOMERSERVICE.Customer.RestControllerTest;
import CUSTOMERSERVICE.Customer.MODEL.Customer;
import CUSTOMERSERVICE.Customer.REPOSITORY.CustomerRepository;
import CUSTOMERSERVICE.Customer.SERVICE_IMPL.CustomerService;
import org.h2.command.dml.MergeUsing;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class ServiceTest {


    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer1;

    private Customer customer2;

    private List<Customer> customerList;
    @Before
     public void setData(){
      customer1 = new Customer();
      customer2 = new Customer();
      customerList = new ArrayList<>();
      customer1.setId(222);
      customer1.setUsername("adarsh");
      customer1.setPassword("aj@7");
      customer1.setAge((byte) 24);

      customer2.setId(111);
      customer2.setUsername("prasad");
      customer2.setPassword("pj@10");
      customerList.add(customer1);
      customerList.add(customer2);

     }


    @Test
    public void getAllCustomerTest()
    {
        given(customerRepository.findAll()).willReturn(customerList);
        List<Customer> customerListActual=customerService.getAllCustomer();
        Assertions.assertEquals(customerList,customerListActual);
    }

    @Test
    public void getCustomerByUsernameAndPassword()
    {
       given(customerRepository.getCustomerByUsernameAndPassword(customer1.getUsername(), customer1.getPassword())).willReturn(customer1);
       Customer customer_actual=customerService.getCustomerByUsernameAndPassword("adarsh","aj@7" );

       Assertions.assertEquals(customer1, customer_actual);


    }

    @Test
    public void getCustomerById()
    {

        given(customerRepository.findById(customer1.getId())).willReturn(Optional.of(customer1));

        Customer customer_actual=customerService.getCustomerById(222);
        assertEquals(customer1,customer_actual);

    }

    @Test
    public void deleteCustomerById()
    {
        Map<String,Boolean> expected = new HashMap<>();
        expected.put("deleted",true);
        given(customerRepository.findById(customer1.getId())).willReturn(Optional.of(customer1));
        Map<String, Boolean> customer_actual= customerService.deleteCustomerById(222);

        Assertions.assertEquals(expected,customer_actual);

    }

    @Test
    public void createNewCustomer()
    {
        given(customerRepository.save(customer1)).willReturn(customer1);

        Customer customer_actual= customerService.createNewCustomer(customer1);


        assertEquals(customer1, customer_actual);
    }


    @Test
    public void getCustomerByAge()
    {
        given(customerRepository.getCustomerByAge(customer1.getAge())).willReturn(customerList);
        List<Customer> customer_actual= customerService.getCustomerByAge((byte) 24);

        assertEquals(customerList, customer_actual);

    }

    @Test
    public void resetPassword()
    {
        given(customerRepository.findByUsername(customer1.getUsername())).willReturn(customer1);
        customer1.setPassword("adarsh1111");
        given(customerRepository.save(customer1)).willReturn(customer1);

       Customer customer_actual=customerRepository.findByUsername(customer1.getUsername());

        //assertThat(customer_actual.getPassword()).isEqualTo("adarsh1111");
        assertEquals(customer1, customer_actual);

    }

    @Test
    public void updateCustomer()
    {
        given(customerRepository.findById(customer1.getId())).willReturn(Optional.of(customer1));
        customer1.setAge((byte) 25);
        customer1.setUsername("adarshkumar");
        given(customerRepository.save(customer1)).willReturn(customer1);

        Customer customer= customerService.getCustomerById(222);
        System.out.println(customer);

        assertEquals(customer1, customer);
    }





}
