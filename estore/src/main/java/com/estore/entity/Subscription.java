package com.estore.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the subscription database table.
 * 
 */
@Entity
@Table(name="subscription")
@NamedQuery(name="Subscription.findAll", query="SELECT s FROM Subscription s")
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int subscriptionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date created;

	@Column(precision=10)
	private BigDecimal paymentAmount;

	private Timestamp paymentDate;

	@Column(length=20)
	private String paymentMode;

	@Column(length=45)
	private String paymentReceipt;

	@Column(nullable=false)
	private byte status;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date subscriptionEndDate;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date subscriptionStartDate;

	private Timestamp updated;

	//bi-directional many-to-one association to Store
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="storeId", nullable=false)
	private Store store;

	//bi-directional many-to-one association to TariffMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tarrifPlanId", nullable=false)
	private TariffMaster tariffMaster;

	public Subscription() {
	}

	public int getSubscriptionId() {
		return this.subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public BigDecimal getPaymentAmount() {
		return this.paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Timestamp getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMode() {
		return this.paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentReceipt() {
		return this.paymentReceipt;
	}

	public void setPaymentReceipt(String paymentReceipt) {
		this.paymentReceipt = paymentReceipt;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Date getSubscriptionEndDate() {
		return this.subscriptionEndDate;
	}

	public void setSubscriptionEndDate(Date subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}

	public Date getSubscriptionStartDate() {
		return this.subscriptionStartDate;
	}

	public void setSubscriptionStartDate(Date subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public TariffMaster getTariffMaster() {
		return this.tariffMaster;
	}

	public void setTariffMaster(TariffMaster tariffMaster) {
		this.tariffMaster = tariffMaster;
	}

}