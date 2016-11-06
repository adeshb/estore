package com.estore.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int productId;

	private byte approvalStatus;

	private int availabilityTime;

	@Column(length=100)
	private String colors;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date created;

	@Column(precision=10, scale=2)
	private BigDecimal discount;

	@Column(length=45)
	private String excludes;

	@Column(length=255)
	private String keyFeatures;

	private int mrp;

	@Column(nullable=false, length=25)
	private String packageContent;

	@Column(nullable=false, length=100)
	private String productName;

	private int productRating;

	private Timestamp publishedFrom;

	private Timestamp publishedUpto;

	private int salePrice;

	@Column(nullable=false)
	private byte status;

	private int stockQuantity;

	private Timestamp updated;

	@Column(nullable=false, length=50)
	private String warranty;

	//bi-directional many-to-one association to SubCategoryMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="subCategoryId", nullable=false)
	private SubCategoryMaster subCategoryMaster;

	//bi-directional many-to-one association to ProductFeature
	@OneToMany(mappedBy="product")
	private List<ProductFeature> productFeatures;

	//bi-directional many-to-one association to ProductImage
	@OneToMany(mappedBy="product")
	private List<ProductImage> productImages;

	//bi-directional many-to-one association to SubCatProductMap
	@OneToMany(mappedBy="product")
	private List<SubCatProductMap> subCatProductMaps;

	//bi-directional many-to-many association to SubCategoryMaster
	@ManyToMany(mappedBy="products2")
	private List<SubCategoryMaster> subCategoryMasters;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public byte getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(byte approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public int getAvailabilityTime() {
		return this.availabilityTime;
	}

	public void setAvailabilityTime(int availabilityTime) {
		this.availabilityTime = availabilityTime;
	}

	public String getColors() {
		return this.colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getExcludes() {
		return this.excludes;
	}

	public void setExcludes(String excludes) {
		this.excludes = excludes;
	}

	public String getKeyFeatures() {
		return this.keyFeatures;
	}

	public void setKeyFeatures(String keyFeatures) {
		this.keyFeatures = keyFeatures;
	}

	public int getMrp() {
		return this.mrp;
	}

	public void setMrp(int mrp) {
		this.mrp = mrp;
	}

	public String getPackageContent() {
		return this.packageContent;
	}

	public void setPackageContent(String packageContent) {
		this.packageContent = packageContent;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductRating() {
		return this.productRating;
	}

	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}

	public Timestamp getPublishedFrom() {
		return this.publishedFrom;
	}

	public void setPublishedFrom(Timestamp publishedFrom) {
		this.publishedFrom = publishedFrom;
	}

	public Timestamp getPublishedUpto() {
		return this.publishedUpto;
	}

	public void setPublishedUpto(Timestamp publishedUpto) {
		this.publishedUpto = publishedUpto;
	}

	public int getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public int getStockQuantity() {
		return this.stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public String getWarranty() {
		return this.warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public SubCategoryMaster getSubCategoryMaster() {
		return this.subCategoryMaster;
	}

	public void setSubCategoryMaster(SubCategoryMaster subCategoryMaster) {
		this.subCategoryMaster = subCategoryMaster;
	}

	public List<ProductFeature> getProductFeatures() {
		return this.productFeatures;
	}

	public void setProductFeatures(List<ProductFeature> productFeatures) {
		this.productFeatures = productFeatures;
	}

	public ProductFeature addProductFeature(ProductFeature productFeature) {
		getProductFeatures().add(productFeature);
		productFeature.setProduct(this);

		return productFeature;
	}

	public ProductFeature removeProductFeature(ProductFeature productFeature) {
		getProductFeatures().remove(productFeature);
		productFeature.setProduct(null);

		return productFeature;
	}

	public List<ProductImage> getProductImages() {
		return this.productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public ProductImage addProductImage(ProductImage productImage) {
		getProductImages().add(productImage);
		productImage.setProduct(this);

		return productImage;
	}

	public ProductImage removeProductImage(ProductImage productImage) {
		getProductImages().remove(productImage);
		productImage.setProduct(null);

		return productImage;
	}

	public List<SubCatProductMap> getSubCatProductMaps() {
		return this.subCatProductMaps;
	}

	public void setSubCatProductMaps(List<SubCatProductMap> subCatProductMaps) {
		this.subCatProductMaps = subCatProductMaps;
	}

	public SubCatProductMap addSubCatProductMap(SubCatProductMap subCatProductMap) {
		getSubCatProductMaps().add(subCatProductMap);
		subCatProductMap.setProduct(this);

		return subCatProductMap;
	}

	public SubCatProductMap removeSubCatProductMap(SubCatProductMap subCatProductMap) {
		getSubCatProductMaps().remove(subCatProductMap);
		subCatProductMap.setProduct(null);

		return subCatProductMap;
	}

	public List<SubCategoryMaster> getSubCategoryMasters() {
		return this.subCategoryMasters;
	}

	public void setSubCategoryMasters(List<SubCategoryMaster> subCategoryMasters) {
		this.subCategoryMasters = subCategoryMasters;
	}

}