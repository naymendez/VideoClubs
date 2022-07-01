package uabc.demo.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "customer")
public class Customer {
	//staff_Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	//staff_id
	private Integer customerId;
	
	//first_name
	@Column(name="first_name")
	private String firstName;
	
	//last_name
	@Column(name="last_name")
	private String lastName;
	
	//email
	@Column(name="email")
	private String email;
	
	//adress_id
	@Column(unique = true)
	private Integer addressId;
	
	//active
	@Column(name="activebool")
	private Boolean activeBool;
	
	//create_date
	@Column(name="create_date", columnDefinition = "DATE")
	@JsonFormat(pattern = "MM/dd/yyyy")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDate createDate;
	
	//last_update
	@Column(name="last_update")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date lastUpdate;
	
	//active
	private Integer active;

	
	//Getters and Setters
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Boolean getActiveBool() {
		return activeBool;
	}

	public void setActiveBool(Boolean activeBool) {
		this.activeBool = activeBool;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}
	
	//Constructor
	public Customer() {
		super();
	}
	
	//toString()
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [customerId=");
		builder.append(customerId);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", addressId=");
		builder.append(addressId);
		builder.append(", activeBool=");
		builder.append(activeBool);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", lastUpdate=");
		builder.append(lastUpdate);
		builder.append(", active=");
		builder.append(active);
		builder.append("]");
		return builder.toString();
	}


	
    }
