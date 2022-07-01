package uabc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uabc.demo.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

	
	@Query(value="SELECT i FROM Inventory i "
			+ "INNER JOIN FETCH i.film f "
			+ "WHERE i.inventoryId = ?1")
	public Inventory findByInventoryId(Integer ticketId);
	
}
