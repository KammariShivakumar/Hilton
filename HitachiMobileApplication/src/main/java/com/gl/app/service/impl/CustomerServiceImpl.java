package com.gl.app.service.impl;
import com.gl.app.dao.*;
import com.gl.app.entity.*;
import com.gl.app.dao.impl.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import com.gl.app.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gl.app.exception.CustomerDoesNotExistException;
import com.gl.app.exception.CustomerTableEmptyException;
import com.gl.app.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	CustomerDAO customerDAO = new CustomerDAOImpl();
	
	public List<SIMDetails> fetchCustomerList(Long customerId) throws SQLException, ClassNotFoundException {
		List<SIMDetails> simDetails=customerDAO.fetchSIMDetails(customerId);
		if(simDetails.isEmpty()){
			System.out.println("no Sim details found");
		}

		return simDetails;
			        
	}

	@Override
	 public String updateCustomerAddress(Long customerId, String city) throws CustomerDoesNotExistException, SQLException, ClassNotFoundException {
        String str=customerDAO.updateCustomerAddress(customerId,city);
		if(str==null){
			System.out.println("invalid");
		}
		return "added successfully";

    }

	@Override
	public List<Customer> getAllCustomers() throws CustomerTableEmptyException, SQLException, ClassNotFoundException {
		List<Customer> customer=customerDAO.getAllCustomers();
		if(customer.isEmpty()){
			System.out.println("no customer details exist");
		}


		return customer;
	    	}
	
}
