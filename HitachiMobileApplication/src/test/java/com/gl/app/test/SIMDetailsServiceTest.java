package com.gl.app.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gl.app.dao.SIMDetailsDAO;
import com.gl.app.entity.SIMDetails;


import static org.junit.jupiter.api.Assertions.*;

import com.gl.app.service.impl.SIMDetailsServiceImpl;
import org.junit.jupiter.api.Test;

import com.gl.app.service.SIMDetailsService;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class SIMDetailsServiceTest {
    @Mock
    SIMDetailsDAO simDetailsDAO = mock(SIMDetailsDAO.class);
    @InjectMocks
    SIMDetailsServiceImpl simDetailsService = new SIMDetailsServiceImpl(simDetailsDAO);


    @Test
    public void testFetchSIMDetailsWithActiveStatus() throws SQLException, ClassNotFoundException {
        //write your code here

        List<SIMDetails> simDetails = new ArrayList<>();
        simDetails.add(new SIMDetails(2L, 234567L, 345678L, "Active", 345678L));
        simDetails.add(new SIMDetails(3L, 234767L, 345688L, "Active", 345698L));
        when(simDetailsDAO.fetchSIMDetailsWithActiveStatus()).thenReturn(simDetails);
        List<SIMDetails> simDetails1 = simDetailsDAO.fetchSIMDetailsWithActiveStatus();
        System.out.println(simDetails);
        for (SIMDetails s : simDetails1) {
            assertEquals("Active", s.getStatus());
        }

    }
}
