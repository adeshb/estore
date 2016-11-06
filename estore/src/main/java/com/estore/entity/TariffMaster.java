package com.estore.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tariff_master database table.
 * 
 */
@Entity
@Table(name="tariff_master")
@NamedQuery(name="TariffMaster.findAll", query="SELECT t FROM TariffMaster t")
public class TariffMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int tariffPlanId;

	@Column(precision=10)
	private BigDecimal catalogFee;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date created;

	@Column(precision=10)
	private BigDecimal eCommPortalFee;

	@Column(nullable=false, precision=10)
	private BigDecimal networkBandwidthLimit;

	@Column(nullable=false, length=45)
	private String planName;

	@Column(nullable=false)
	private int productCatalogLimit;

	@Column(nullable=false)
	private int productUpdateLimit;

	@Column(nullable=false, precision=10)
	private BigDecimal registrationFee;

	private byte status;

	@Column(nullable=false, precision=10)
	private BigDecimal subDomainFee;

	private Timestamp updated;

	@Column(precision=10)
	private BigDecimal websiteFee;

	//bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy="tariffMaster")
	private List<Subscription> subscriptions;

	public TariffMaster() {
	}

	public int getTariffPlanId() {
		return this.tariffPlanId;
	}

	public void setTariffPlanId(int tariffPlanId) {
		this.tariffPlanId = tariffPlanId;
	}

	public BigDecimal getCatalogFee() {
		return this.catalogFee;
	}

	public void setCatalogFee(BigDecimal catalogFee) {
		this.catalogFee = catalogFee;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public BigDecimal getECommPortalFee() {
		return this.eCommPortalFee;
	}

	public void setECommPortalFee(BigDecimal eCommPortalFee) {
		this.eCommPortalFee = eCommPortalFee;
	}

	public BigDecimal getNetworkBandwidthLimit() {
		return this.networkBandwidthLimit;
	}

	public void setNetworkBandwidthLimit(BigDecimal networkBandwidthLimit) {
		this.networkBandwidthLimit = networkBandwidthLimit;
	}

	public String getPlanName() {
		return this.planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getProductCatalogLimit() {
		return this.productCatalogLimit;
	}

	public void setProductCatalogLimit(int productCatalogLimit) {
		this.productCatalogLimit = productCatalogLimit;
	}

	public int getProductUpdateLimit() {
		return this.productUpdateLimit;
	}

	public void setProductUpdateLimit(int productUpdateLimit) {
		this.productUpdateLimit = productUpdateLimit;
	}

	public BigDecimal getRegistrationFee() {
		return this.registrationFee;
	}

	public void setRegistrationFee(BigDecimal registrationFee) {
		this.registrationFee = registrationFee;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public BigDecimal getSubDomainFee() {
		return this.subDomainFee;
	}

	public void setSubDomainFee(BigDecimal subDomainFee) {
		this.subDomainFee = subDomainFee;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public BigDecimal getWebsiteFee() {
		return this.websiteFee;
	}

	public void setWebsiteFee(BigDecimal websiteFee) {
		this.websiteFee = websiteFee;
	}

	public List<Subscription> getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Subscription addSubscription(Subscription subscription) {
		getSubscriptions().add(subscription);
		subscription.setTariffMaster(this);

		return subscription;
	}

	public Subscription removeSubscription(Subscription subscription) {
		getSubscriptions().remove(subscription);
		subscription.setTariffMaster(null);

		return subscription;
	}

}