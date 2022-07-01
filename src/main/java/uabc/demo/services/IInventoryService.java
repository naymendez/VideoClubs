package uabc.demo.services;

import uabc.demo.entities.Inventory;

public interface IInventoryService {
	
	public Inventory findByInventoryId(Integer inventoryId);
}
