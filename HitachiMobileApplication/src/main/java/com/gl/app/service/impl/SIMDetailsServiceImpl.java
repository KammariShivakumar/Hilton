package com.gl.app.service.impl;
import java.util.List;
import com.gl.app.dao.*;
import com.gl.app.dao.impl.*;
import java.util.stream.Collectors;
import java.util.ArrayList;

import com.gl.app.entity.SIMDetails;
import com.gl.app.exception.SIMDoesNotExistsException;
import com.gl.app.service.SIMDetailsService;
import com.gl.app.util.*;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class SIMDetailsServiceImpl implements SIMDetailsService{
	SIMDetailsDAO simDetailsDAO = new SIMDetailsDAOImpl();

	public SIMDetailsServiceImpl () {

	}

	public SIMDetailsServiceImpl(SIMDetailsDAO simDetailsDAO) {
		this.simDetailsDAO=simDetailsDAO;

	}

	@Override
	public List<SIMDetails> fetchSIMDetailsWithActiveStatus() throws SQLException, ClassNotFoundException {
	List<SIMDetails> simDetails=simDetailsDAO.fetchSIMDetailsWithActiveStatus();
	if(simDetails.isEmpty()) {
		System.out.println("no sim details with Active status");
	}

	return simDetails;
	    }

	@Override
	 public String getSimStatus(long simId, long simNumber) throws SIMDoesNotExistsException, SQLException, ClassNotFoundException {
	String str=simDetailsDAO.getSimStatus(simId,simNumber);
	if(str==null)

		System.out.println("SIMDoesNotExistsException");


          return str;
    }
	
		
	}


