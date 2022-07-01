package uabc.demo.entities;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "staff")
public class Staff {
	//staff_Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="staff_id")
	//staff_id
	private Integer staffId;
	
	//first_name
	@Column(name="first_name")
	private String firstName;
	
	//last_name
	@Column(name="last_name")
	private String lastName;
	
	//adress_id
	@Column(unique = true)
	private Integer addressId;
	
	//email
	@Column(name="email")
	private String email;
	
	//store_id
	@Column(name="store_id")
	private Integer storeId;
	
	//active
	private Boolean active;
	
	//username
	private String username;
	
	//password
	private String password;
	
	//last_update
	@Column(name="last_update")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date lastUpdate;
	
	//picture
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] picture;

	
	//Getters and Setters
	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
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

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	//Constructor
	public Staff() {
		super();
	}
	//toString()
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Staff [staffId=");
		builder.append(staffId);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", addressId=");
		builder.append(addressId);
		builder.append(", email=");
		builder.append(email);
		builder.append(", storeId=");
		builder.append(storeId);
		builder.append(", active=");
		builder.append(active);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", lastUpdate=");
		builder.append(lastUpdate);
		builder.append(", picture=");
		builder.append(Arrays.toString(picture));
		builder.append("]");
		return builder.toString();
	}

	
	
}
