package com.gl.app;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

import com.gl.app.dao.impl.CustomerDAOImpl;
import com.gl.app.entity.Customer;
import com.gl.app.entity.SIMDetails;
import com.gl.app.exception.*;
import com.gl.app.service.*;
import com.gl.app.service.impl.*;

public class HitachiMobileApplication {

	
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	CustomerService customerService = new CustomerServiceImpl();
    SIMDetailsService simDetailsService = new SIMDetailsServiceImpl();
   
	
	 Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("1. Fetch Sim Details by Customer ID");
        System.out.println("2. Update customer address");
        System.out.println("3. Get all customers");
        System.out.println("4. Fetch active SIM details");
        System.out.println("5. Get SIM status");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter the customer ID");
                Long customerID= scanner.nextLong();
                List<SIMDetails> simDetails=customerService.fetchCustomerList(customerID);
//                System.out.println(simDetails);
//                for(SIMDetails x : simDetails)
//                {
//                    System.out.println(x);
//                }
                simDetails.stream().forEach(System.out::println);
           // write code to fetch sim details by customer id
                
                break;
            case 2:
                System.out.println("Enter customerID");
                Long customeriD= scanner.nextLong();
                System.out.println("Enter New Address");
                String newaddress=scanner.nextLine();
                String s= customerService.updateCustomerAddress(customeriD,newaddress);
                System.out.println(s);

                break; 
            case 3:
                List<Customer> customers=customerService.getAllCustomers();
                System.out.println(customers);
               //write code to fetch all customers
                break;
                
         
            case 4:
                List<SIMDetails> simDetails1=simDetailsService.fetchSIMDetailsWithActiveStatus();
                System.out.println(simDetails1);
              //Write code to fetch active sim details
                break;
            case 5:
                String str= simDetailsService.getSimStatus(9876543210L,1234567890L);
                System.out.println(str);
               //Write code to fetch sim status
                break;
           
            case 6:
                System.out.println("Exiting...");
			try {
				scanner.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 6.");
        }
    }
}
}
