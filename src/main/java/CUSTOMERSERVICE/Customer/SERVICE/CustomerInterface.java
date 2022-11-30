package CUSTOMERSERVICE.Customer.SERVICE;

import CUSTOMERSERVICE.Customer.MODEL.Customer;

import java.util.List;
//CustomerService
public interface CustomerInterface {

    public List getAllCustomer();

    public Customer createNewCustomer(Customer customer);

    public Customer getCustomerById(long id);

    public Customer updateCustomer(long id, Customer customer);

    public Customer deleteCustomerById(long id);


}
