package CUSTOMERSERVICE.Customer.REPOSITORY;

import CUSTOMERSERVICE.Customer.MODEL.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
