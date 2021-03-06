package com.invoiceApp.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityExistsException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoiceApp.entity.Customer;
import com.invoiceApp.repository.CustomerRepository;
import com.invoiceApp.response.CustomerResponse;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	ModelMapper modelMapper = new ModelMapper();

	public Customer createCustomer(Customer customer) {
		if (customerRepository.findByName(customer.getName()) != null)
			throw new EntityExistsException();
		return customerRepository.save(customer);
	}

	public Customer findById(Long id) {
		try {
			return customerRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			System.out.println("No such element");
			return null;
		}
	}

	public Customer findByName(String name) {
		try {
			return customerRepository.findByName(name);
		} catch (NoSuchElementException e) {
			System.out.println("No such element");
			return null;
		}
	}

	public Customer findByPib(String pib) {
		try {
			return customerRepository.findByPib(pib);
		} catch (NoSuchElementException e) {
			System.out.println("No such element");
			return null;
		}
	}

	public List<Customer> findAll() {
		return (List<Customer>) customerRepository.findAll();
	}

	public Customer updateCustomer(Customer customer) {
		try {
			return customerRepository.save(customer);
		} catch (NoSuchElementException e) {
			e.toString();
			return new Customer();
		}
	}

	public String deleteCustomer(String name) {
		try {
			Customer customer = customerRepository.findByName(name);
			customerRepository.delete(customer);
			return "Customer deleted";
		} catch (NoSuchElementException e) {
			e.toString();
			return "Customer does not exist.";
		}
	}

	public CustomerResponse customerToCustomerDto(Customer customer) {
		CustomerResponse customerDto = new CustomerResponse();
		modelMapper.map(customer, customerDto);
		return customerDto;
	}

	public Customer customerDtoToCustomer(CustomerResponse customerDto) {
		Customer returnValue = new Customer();
		Customer customer = findByName(customerDto.getName());
		modelMapper.map(customerDto, returnValue);
		returnValue.setId(customer.getId());
		returnValue.setInvoices(customer.getInvoices());
		return returnValue;
	}

}
