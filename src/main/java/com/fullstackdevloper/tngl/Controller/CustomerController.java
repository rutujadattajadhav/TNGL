package com.fullstackdevloper.tngl.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackdevloper.tngl.Beans.CustomerBean;
import com.fullstackdevloper.tngl.Service.CustomerService;
@CrossOrigin
@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/addaCustomer")
	public String add( @RequestBody CustomerBean customerBean) {
		String customBean	=customerService.addCustomer( customerBean);		
		return customBean;		
	}
	
	@PostMapping("/updateCustomer")
	public String update(@RequestBody CustomerBean customerBean) {		
		return customerService.updateCustomer(customerBean);	
	}
	
	@DeleteMapping("/deleteCustomer")
	public String delete (@RequestHeader String customerNumber) {
		return customerService.deleteCustomer(customerNumber);}
	
	
	@DeleteMapping("/deleteCustomersByIds")
	public String deleteAll(@RequestBody List<String> costomerNumbers) {
		return customerService.deleteAllByCustomerId(costomerNumbers);
		
	}
	
	@GetMapping("/findAllCustomer")
	public List<CustomerBean> findAll() {
		
		return customerService.findAllCustomer();
		
	}

}
