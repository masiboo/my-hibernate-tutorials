package com.example.foreignkeybasedonetoone.repository;

import com.example.foreignkeybasedonetoone.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {

}
