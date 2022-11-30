package CUSTOMERSERVICE.Customer.SERVICE_IMPL;

import CUSTOMERSERVICE.Customer.DTO.CustomerDTO;
import CUSTOMERSERVICE.Customer.EXCEPTION.Resourcenotfound;
import CUSTOMERSERVICE.Customer.MODEL.Customer;
import CUSTOMERSERVICE.Customer.REPOSITORY.CustomerRepository;
import CUSTOMERSERVICE.Customer.REPOSITORY.CustomerRepository;
import CUSTOMERSERVICE.Customer.SERVICE.CustomerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//CustomerServiceImpl
@Service
public class CustomerService implements CustomerInterface {

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public Customer createNewCustomer(Customer customer) {
//       Customer customer1=  cusacustomerRepo.findByEmia(customer.getEmail())
//         if(customer1==null) {
//             return customerRepo.save(customer);
//          }
//         else{
//             return
//         }
        return customerRepo.save(customer);
     }

    @Override
    public Customer getCustomerById(long id) {
        return customerRepo.findById(id).get();
    }

    @Override
    public Customer updateCustomer(long id, Customer customer_details) {
        Customer details= customerRepo.findById(id).orElseThrow(()->new RuntimeException("Given ID doesn't exist"));
        details.setName(customer_details.getName());
        details.setAge(customer_details.getAge());
        details.setEmail(customer_details.getEmail());
        details.setNumber(customer_details.getNumber());
        details.setUsername(customer_details.getUsername());
        details.setPassword(customer_details.getPassword());
        details.setAge(customer_details.getAge());
        details.setGender(customer_details.getGender());

        return customerRepo.save(details);
    }

    @Override
    public Customer deleteCustomerById(long id) {
        Customer deleteinfo= customerRepo.findById(id).orElseThrow(()->new RuntimeException("Gievn ID doesn't exist"));
        customerRepo.delete(deleteinfo);

        return deleteinfo;
    }
}
