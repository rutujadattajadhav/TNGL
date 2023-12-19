package com.fullstackdevloper.tngl.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fullstackdevloper.tngl.Beans.CustomerBean;
@Repository
public interface CustomerRepository  extends CrudRepository<CustomerBean,String> {

}
