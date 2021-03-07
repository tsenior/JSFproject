package com.tinyiko.jsf;

import java.util.HashMap;
import java.util.Map;

public class InventoryServiceImpl implements InventoryService {
	
	private Map<Long, InvetoryItem> inventoryItem = new HashMap<>();

	@Override
	public void createItem(Long catalogItemId, String name) {
		
		long inventoryItemId = inventoryItem.size() + 1;
		this.inventoryItem.put(inventoryItemId, new InvetoryItem(inventoryItemId, catalogItemId, name,0L));
	}

	@Override
	public Long getQuantity(Long catalogItemId) {
		return 0L;
	}

}
