package com.fullstackdevloper.tngl.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstackdevloper.tngl.Beans.CustomerBean;
import com.fullstackdevloper.tngl.Repo.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	public String addCustomer(CustomerBean customerBean) {
		if(customerRepository.existsById(customerBean.customerNumber)) {
			return "Customer Allready exists";
		}
		CustomerBean customerbean1	=customerRepository.save(customerBean);			
		return "Add Successfully in DB";		
	}
	
	
	public String updateCustomer(CustomerBean customerBean) {
		if(customerRepository.existsById(customerBean.customerNumber)) {
			CustomerBean bean	=customerRepository.save(customerBean);
		}else {
			return "Customer not found";
		}
		return "Update Successfully in DB";	
	}
	
	public String deleteCustomer(String customerNumber) {
		if( customerRepository.existsById(customerNumber)) {
			customerRepository.deleteById(customerNumber);
			return "Successfully deleted From DB";
		}
		else {
			return "not found";
		}	
	}
	
	public String deleteAllByCustomerId(List<String> customerNumbers) {
		for(String customerNumber:customerNumbers) {
			if(!customerRepository.existsById(customerNumber)){
				return "Customer not found by this ID :"+customerNumber;			
			}
		}
		customerRepository.deleteAllById(customerNumbers);
		return "Sucessfully delete all coustomers";
	}
	
	public List<CustomerBean> findAllCustomer() {
		Iterable<CustomerBean> findAllCust = customerRepository.findAll();
		List<CustomerBean> customer=new ArrayList<>();
		findAllCust.forEach((obj)->{
			customer.add(obj);
		});
		
		return customer;
		
		
	}

}
