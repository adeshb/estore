package com.estore.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int addressId;

	@Column(length=45)
	private String blockORwing;

	@Column(nullable=false, length=15)
	private String city;

	@Column(nullable=false, length=10)
	private String country;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date created;

	@Column(length=15)
	private String floor;

	@Column(nullable=false, length=100)
	private String locality;

	@Column(nullable=false)
	private int pin;

	@Column(nullable=false, length=45)
	private String premiseName;

	@Column(nullable=false, length=45)
	private String premiseNo;

	@Column(nullable=false, length=15)
	private String state;

	@Column(nullable=false, length=100)
	private String streetLane;

	private Timestamp updated;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="address")
	private List<User> users;

	public Address() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getBlockORwing() {
		return this.blockORwing;
	}

	public void setBlockORwing(String blockORwing) {
		this.blockORwing = blockORwing;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getFloor() {
		return this.floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getLocality() {
		return this.locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public int getPin() {
		return this.pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getPremiseName() {
		return this.premiseName;
	}

	public void setPremiseName(String premiseName) {
		this.premiseName = premiseName;
	}

	public String getPremiseNo() {
		return this.premiseNo;
	}

	public void setPremiseNo(String premiseNo) {
		this.premiseNo = premiseNo;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreetLane() {
		return this.streetLane;
	}

	public void setStreetLane(String streetLane) {
		this.streetLane = streetLane;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setAddress(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setAddress(null);

		return user;
	}

}