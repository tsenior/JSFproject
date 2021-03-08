package com.tinyiko.jsf;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@ApplicationScoped
@Alternative
public class InventoryServiceRemoteImpl implements InventoryService {
	
	private Map<Long, InvetoryItem> inventoryItem = new HashMap<>();

	@Override
	public void createItem(Long catalogItemId, String name) {
		long inventoryItemId = inventoryItem.size() + 1;
		this.inventoryItem.put(inventoryItemId, new InvetoryItem(inventoryItemId, catalogItemId, name,0L));
		
		this.printInventory();
	}

	private void printInventory() {
		System.out.println("This will assist in understing sessions. - So Remote inventory contains: ");
		
		for(Entry<Long, InvetoryItem> entry: this.inventoryItem.entrySet()) {
			System.out.println(entry.getValue().getName());
		}
		
	}

	@Override
	public Long getQuantity(Long catalogItemId) {
		return 0L;
	}

}
