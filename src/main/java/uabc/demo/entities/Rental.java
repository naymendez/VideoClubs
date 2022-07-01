package uabc.demo.entities;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "rental")
public class Rental {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rental_id")
	private Integer rentalId;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	@Column(name = "rental_date")
	private java.sql.Timestamp rentalDate;
	
	@Column(name = "inventory_id")
	private Integer inventoryId;
	
	@Column(name = "customer_id")
	private Integer customerId;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	@Column(name = "return_date")
	private java.sql.Timestamp returnDate;
	
	@Column(name = "staff_id")
	private Integer staffId;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	@Column(name = "last_update")
	private java.sql.Timestamp lastUpdate;

	public Integer getRentalId() {
		return rentalId;
	}

	public void setRentalId(Integer rentalId) {
		this.rentalId = rentalId;
	}

	public java.sql.Timestamp getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(java.sql.Timestamp rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public java.sql.Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(java.sql.Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public java.sql.Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(java.sql.Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Rental() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rental [rentalId=");
		builder.append(rentalId);
		builder.append(", rentalDate=");
		builder.append(rentalDate);
		builder.append(", inventoryId=");
		builder.append(inventoryId);
		builder.append(", customerId=");
		builder.append(customerId);
		builder.append(", returnDate=");
		builder.append(returnDate);
		builder.append(", staffId=");
		builder.append(staffId);
		builder.append(", lastUpdate=");
		builder.append(lastUpdate);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
