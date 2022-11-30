package CUSTOMERSERVICE.Customer.CONTROLLER;

import CUSTOMERSERVICE.Customer.DTO.AddressDTO;
import CUSTOMERSERVICE.Customer.DTO.CustomerDTO;
import CUSTOMERSERVICE.Customer.MODEL.Address;
import CUSTOMERSERVICE.Customer.MODEL.Customer;
import CUSTOMERSERVICE.Customer.SERVICE_IMPL.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public  ResponseEntity<List<Customer>> getAllCustomer() {
        return ResponseEntity.ok().body(customerService.getAllCustomer());
    }

    @PostMapping("/newcustomer")
    public Customer createNewCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println("customerDTO ----_>"+customerDTO.toString());

        Customer customer =convertCustomerdtoToCustomer(customerDTO);
        return customerService.createNewCustomer(customer);
    }

    @GetMapping("{id}")
    public Customer getCustomerById(@PathVariable long id)
    {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/update{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody CustomerDTO customerDTO)
    {
        Customer customer=convertCustomerdtoToCustomer(customerDTO);
         customerService.updateCustomer(id, customer);
         return ResponseEntity.ok().body(customer);

    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Customer> deleteCustomerById(@PathVariable long id)
    {
        Customer customer_details=customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private Customer convertCustomerdtoToCustomer(CustomerDTO customerDTO ) {
        List<Address> addressList = new ArrayList<>();

        for (AddressDTO addressDTO:customerDTO.getAddressDTOList())
            {
                Address address = convertAddressdtoToAddress(addressDTO);
                addressList.add(address);
            }

        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer.setDetailsList(addressList);
        return customer;
    }


    private CustomerDTO convertCustomerToCustomerDTO(Customer customer ) {
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }

    private Address convertAddressdtoToAddress(AddressDTO addressDTO ) {
        Address address = modelMapper.map(addressDTO, Address.class);
        return address;
    }


    private AddressDTO convertAddressdtoToAddress(Address address ) {
        AddressDTO addressDTO = modelMapper.map(address, AddressDTO.class);
        return addressDTO;
    }



}