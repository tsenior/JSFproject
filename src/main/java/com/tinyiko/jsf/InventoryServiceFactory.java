package com.tinyiko.jsf;

import java.time.LocalDateTime;

import javax.ws.rs.Produces;

//@Produces disable to force InventoryServiceLocalImpl so i can see the logging function(note @Alternate removed from InventoryServiceLocalImpl as well.)
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
