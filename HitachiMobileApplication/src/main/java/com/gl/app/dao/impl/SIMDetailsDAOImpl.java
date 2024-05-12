package com.gl.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.gl.app.dao.SIMDetailsDAO;
import com.gl.app.entity.SIMDetails;
import com.gl.app.exception.SIMDoesNotExistsException;
import com.gl.app.util.HitachiUtil;

public class SIMDetailsDAOImpl implements SIMDetailsDAO{
HitachiUtil hitachiUtil = new HitachiUtil();

	
	
	@Override

	public List<SIMDetails> fetchSIMDetailsWithActiveStatus() throws ClassNotFoundException, SQLException {
		Connection con=HitachiUtil.getConnection();
		List<SIMDetails> simDetails=new ArrayList<>();
		String query="select *from sim_details where status='Active'";
		PreparedStatement ps= con.prepareStatement(query);
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
		System.out.println("fetched sim details with active status successfully");



		return simDetails;
		// Write code to fetch SIM details with active status

	    }


	@Override
	 public String getSimStatus(long simNumber, long serviceNumber) throws SIMDoesNotExistsException, SQLException, ClassNotFoundException {
		Connection con=HitachiUtil.getConnection();
		String query="select status from sim_details where sim_number=? and service_number=?";
		PreparedStatement ps= con.prepareStatement(query);
		ps.setLong(1,simNumber);
		ps.setLong(2,serviceNumber);
		ResultSet res=ps.executeQuery();
		String status=null;
		while(res.next()){
			status =res.getString("status");
			System.out.println("fetched sim status successfully");
		}





           // Write code to get SIM status
		return status;
    }
	

	
}
