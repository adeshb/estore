package com.estore.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the store database table.
 * 
 */
@Entity
@NamedQuery(name="Store.findAll", query="SELECT p FROM Store p")
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int storeId;

	private String storeName;

	//bi-directional one-to-one association to Address
	@OneToOne
	@JoinColumn(name="storeAddressId")
	private Address storeAddressId;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="ownerId")
	private User ownerId;

	private BigDecimal longitude;

	private BigDecimal latitude;

	private String openDays;
	
	private Time opens;

	private Time closes;
	
	@JsonIgnore
	@Lob
	private byte[] frontImage;
	
	private String extDomainIP;

	private String storeSubDomain;
	
	private byte status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	private String speciality;
	
	private int storeRating;
	
	private byte[] logoImage;

	private Timestamp updated;

	//bi-directional one-to-one association to Address
	@OneToOne
	@JoinColumn(name="billingAddressId")
	private Address billingAddressId;

	//bi-directional one-to-one association to Subscription
	@OneToMany(mappedBy="store")
	private List<Subscription> subscriptions;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="userId")
	private List<User> users;


	public Store() {
	}


	public int getStoreId() {
		return storeId;
	}


	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public Address getStoreAddressId() {
		return storeAddressId;
	}


	public void setStoreAddressId(Address storeAddressId) {
		this.storeAddressId = storeAddressId;
	}


	public User getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(User ownerId) {
		this.ownerId = ownerId;
	}


	public BigDecimal getLongitude() {
		return longitude;
	}


	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}


	public BigDecimal getLatitude() {
		return latitude;
	}


	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}


	public String getOpenDays() {
		return openDays;
	}


	public void setOpenDays(String openDays) {
		this.openDays = openDays;
	}


	public Time getOpens() {
		return opens;
	}


	public void setOpens(Time opens) {
		this.opens = opens;
	}


	public Time getCloses() {
		return closes;
	}


	public void setCloses(Time closes) {
		this.closes = closes;
	}


	public byte[] getFrontImage() {
		return frontImage;
	}


	public void setFrontImage(byte[] frontImage) {
		this.frontImage = frontImage;
	}


	public String getExtDomainIP() {
		return extDomainIP;
	}


	public void setExtDomainIP(String extDomainIP) {
		this.extDomainIP = extDomainIP;
	}


	public String getStoreSubDomain() {
		return storeSubDomain;
	}


	public void setStoreSubDomain(String storeSubDomain) {
		this.storeSubDomain = storeSubDomain;
	}


	public byte getStatus() {
		return status;
	}


	public void setStatus(byte status) {
		this.status = status;
	}


	public Date getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}


	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	public int getStoreRating() {
		return storeRating;
	}


	public void setStoreRating(int storeRating) {
		this.storeRating = storeRating;
	}


	public byte[] getLogoImage() {
		return logoImage;
	}


	public void setLogoImage(byte[] logoImage) {
		this.logoImage = logoImage;
	}


	public Timestamp getUpdated() {
		return updated;
	}


	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}


	public Address getBillingAddressId() {
		return billingAddressId;
	}


	public void setBillingAddressId(Address billingAddressId) {
		this.billingAddressId = billingAddressId;
	}


	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}


	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}