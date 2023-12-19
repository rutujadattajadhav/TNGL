package com.fullstackdevloper.tngl.Beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerBean {
	
	@Column
	public String name;
	
	@Column
	public String address;
	
	@Id
	@Column
	public String customerNumber;
	
	@Column
	public String meterSerilNumber;
	

}
