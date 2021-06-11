
package com.residencia.dell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.residencia.dell.entities.Customers;
import com.residencia.dell.repositories.CustomersRepository;


@Service
public class CustomerService {

	@Autowired
	public CustomersRepository customerRepository;

	public Customers findById(Integer id) {
		return customerRepository.findById(id).get();
	}

	public List<Customers> findAll(Pageable page) {
		return customerRepository.findAll(page).getContent();
	}

	public Long count() {
		return customerRepository.count();
	}

	public Customers save(Customers customer) {
		Customers newCustomer = customerRepository.save(customer);
		return newCustomer;
	}

	public void delete(Integer id) {
		customerRepository.deleteById(id);
	}

	public Customers update(Customers customer, Integer id) {
		Customers newCustomer = customerRepository.findById(id).get();
		return customerRepository.save(newCustomer);
	}

}
