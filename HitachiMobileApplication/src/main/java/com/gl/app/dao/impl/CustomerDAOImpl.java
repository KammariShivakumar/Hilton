package com.gl.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gl.app.dao.CustomerDAO;
import com.gl.app.entity.Customer;
import com.gl.app.entity.SIMDetails;
import com.gl.app.exception.CustomerDoesNotExistException;
import com.gl.app.exception.CustomerTableEmptyException;
import com.gl.app.util.HitachiUtil;

public class CustomerDAOImpl implements CustomerDAO {

	Connection con = null;



	@Override
	public String updateCustomerAddress(Long customerId, String newAddress) throws CustomerDoesNotExistException, SQLException, ClassNotFoundException {
		con = HitachiUtil.getConnection();

		String query = "update customer set address =? where customer_id=?";

		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, newAddress);
		ps.setLong(2, customerId);
		int res = ps.executeUpdate();
		if (res == 1) {
			return "address updated successfully";
		}
//		ps.close();
//		con.close();

		return "invalid customer id";


	}


	@Override
	public List<Customer> getAllCustomers() throws CustomerTableEmptyException, ClassNotFoundException, SQLException {
		con = HitachiUtil.getConnection();
		List<Customer> customer = new ArrayList<>();
		String query = "select *from customer";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet res= ps.executeQuery();
		while(res.next()){
			Long customer_id = res.getLong(1);
			String  dateOfBirth= res.getString( 2);
			String emailAddress=res.getString(3);
			String firstName=res.getString(4);
			String lastName=res.getString(5);
			String idType=res.getString(6);
			String address=res.getString(7);
			String state=res.getString(8);



			Customer customer1=new Customer(customer_id,dateOfBirth, emailAddress, firstName,lastName, idType, address
					, state);

			customer.add(customer1);

		}
		System.out.println("fetched details of customers successfully");
		return customer ;








	}
	// Write code to fetch all customers


	@Override

	public List<SIMDetails> fetchSIMDetails(Long customerId) throws SQLException, ClassNotFoundException {
		con = HitachiUtil.getConnection();
		List<SIMDetails> simDetails=new ArrayList<>();
		String query="select *from sim_details where customer_id=?";
		PreparedStatement ps= con.prepareStatement(query);
		ps.setLong(1,customerId);
		ResultSet res=ps.executeQuery();
		while(res.next()){

			long simId=res.getLong(1);
			 long serviceNumber=res.getLong(2);
			 long simNumber=res.getLong(3);
			 String status=res.getString(4);
			 Long uniqueIdNumber=res.getLong(5);

			 SIMDetails simDetails1=new SIMDetails( simId,serviceNumber,simNumber,status,uniqueIdNumber);
			 simDetails.add(simDetails1);
		}
		System.out.println("fetched sim details succcessfully");



		return simDetails;
	}

}