package com.tinyiko.jsf;

import java.time.LocalDateTime;

import javax.ws.rs.Produces;

@Produces
public class InventoryServiceFactory {
	
	public InventoryService inventoryServiceToInvoke() {
		
		InventoryService inventoryService = null;
		
		if(!(LocalDateTime.now().getHour() > 12)) {
			inventoryService = new InventoryServiceLocalImpl();
		}else {
			inventoryService = new InventoryServiceRemoteImpl();
			
		}
		
		return inventoryService;
	}

}
