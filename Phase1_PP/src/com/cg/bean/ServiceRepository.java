package com.cg.bean;

import java.util.HashMap;

public class ServiceRepository {
	
	public static HashMap<String,Account> repository=new HashMap<>();
	
	public static void addRecord() {
		
		repository.put("7939100052998",new Account("7939100052998","kush","Ankit","M"));
		repository.put("7939100012345",new Account("7939100012345","neil","nitin","M"));
		repository.put("7939100023456",new Account("7939100023456","koli","mukesh","F"));
		
	}
}
