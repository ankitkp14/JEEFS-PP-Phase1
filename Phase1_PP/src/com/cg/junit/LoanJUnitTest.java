package com.cg.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.bean.ServiceRepository;
import com.cg.service.LoanServiceImpl;

public class LoanJUnitTest {

	static LoanServiceImpl service = null;
	
	@BeforeClass
	public static void checkBefore() {
		service=new LoanServiceImpl();
	}
	 
	@Before
	public void BeforeCheck() {
		new ServiceRepository().addRecord();
		System.out.println("\nChecking details..");
	}
	
	@Test
	public void test() {
		
		System.out.println("\nLogin..");
	    assertEquals(true,service.logIn("7939100052998", "kush"));
	    assertEquals(false,service.logIn("7939100052998", "kush12"));
	    
	    assertEquals(true, service.checkPass("Kush@2"));
	    assertEquals(false, service.checkPass("Kush@"));
	    assertEquals(true, service.checkName("Ankit"));
	    assertEquals(false, service.checkUserId("Kush@2"));
	    assertEquals(true, service.checkUserId("12345678901"));
	}
	
	@After
	public void CheckedAfter() {
		System.out.println("\nVerified..");
	}
	
	@AfterClass
	public static void AfterCheck() {
		System.out.println("\nFinished Testing..");
	}

}
