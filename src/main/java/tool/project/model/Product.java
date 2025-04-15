package tool.project.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @Column(nullable = true)
    private String sku;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String name;

    private Integer published;

    private Integer isFeatured;

    private String visibilityInCatalog;

    @Lob
    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String shortDescription;

    @Lob
    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String description;

    @Column(nullable = true)
    private Long dateSalePriceStarts;

    @Column(nullable = true)
    private Long dateSalePriceEnds;

    private String taxStatus;

    @Column(nullable = true)
    private String taxClass;

    private Integer inStock;

    @Column(nullable = true)
    private Integer stock;

    @Column(nullable = true)
    private Integer lowStockAmount;

    @Column(nullable = true)
    private Integer backordersAllowed;

    @Column(nullable = true)
    private Integer soldIndividually;

    @Column(nullable = true)
    private Double weight;

    @Column(nullable = true)
    private Double length;
    
    @Column(nullable = true)
    private Double width;

    @Column(nullable = true)
    private Double height;

    private Integer allowCustomerReviews;

    @Lob
    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String purchaseNote;
    
    
    @Column(nullable = true)
    private Double salePrice;

    @Column(nullable = true)
    private Double regularPrice;

    @ManyToMany
    @JoinTable(
        name = "product_categories",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();


    @Column(nullable = true)
    private String tags;

    @Column(nullable = true)
    private String shippingClass;

    @Lob
    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String images;

    @Column(nullable = true)
    private Integer downloadLimit;

    @Column(nullable = true)
    private Integer downloadExpiryDays;

    @Column(nullable = true)
    private String parent;

    @Column(nullable = true)
    private String groupedProducts;

    @Column(nullable = true)
    private String upsells;

    @Column(nullable = true)
    private String crossSells;

    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String externalUrl;

    @Column(nullable = true)
    private String buttonText;

    @Column(nullable = true)
    private Integer position;

    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String attribute1Name;

    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String attribute1Value;

    @Column(nullable = true)
    private Integer attribute1Visible;

    @Column(nullable = true)
    private Integer attribute1Global;

    @Lob
    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String attribute1Default;

    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String attribute2Name;

    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String attribute2Value;

    @Column(nullable = true)
    private Integer attribute2Visible;

    @Column(nullable = true)
    private Integer attribute2Global;

    @Lob
    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String attribute2Default;

    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String attribute3Name;

    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String attribute3Value;

    @Column(nullable = true)
    private Integer attribute3Visible;

    @Column(nullable = true)
    private Integer attribute3Global;

    @Lob
    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String attribute3Default;

    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String attribute4Name;

    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String attribute4Value;

    @Column(nullable = true)
    private Integer attribute4Visible;

    @Column(nullable = true)
    private Integer attribute4Global;

    @Lob
    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String attribute4Default;

    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String attribute5Name;

    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String attribute5Value;

    @Column(nullable = true)
    private Integer attribute5Visible;

    @Column(nullable = true)
    private Integer attribute5Global;

    @Lob
    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String attribute5Default;

    public Product() {}

    public Product(
        String type,
        String sku,
        String name,
        Integer published,
        Integer isFeatured,
        String visibilityInCatalog,
        String shortDescription,
        String description,
        Long dateSalePriceStarts,
        Long dateSalePriceEnds,
        String taxStatus,
        String taxClass,
        Integer inStock,
        Integer stock,
        Integer lowStockAmount,
        Integer backordersAllowed,
        Integer soldIndividually,
        Double weight,
        Double length,
        Double width,
        Double height,
        Integer allowCustomerReviews,
        String purchaseNote,
        Double salePrice,
        Double regularPrice,
        List<Category> categories,
        String tags,
        String shippingClass,
        String images,
        Integer downloadLimit,
        Integer downloadExpiryDays,
        String parent,
        String groupedProducts,
        String upsells,
        String crossSells,
        String externalUrl,
        String buttonText,
        Integer position,
        String attribute1Name,
        String attribute1Value,
        Integer attribute1Visible,
        Integer attribute1Global,
        String attribute1Default,
        String attribute2Name,
        String attribute2Value,
        Integer attribute2Visible,
        Integer attribute2Global,
        String attribute2Default,
        String attribute3Name,
        String attribute3Value,
        Integer attribute3Visible,
        Integer attribute3Global,
        String attribute3Default,
        String attribute4Name,
        String attribute4Value,
        Integer attribute4Visible,
        Integer attribute4Global,
        String attribute4Default,
        String attribute5Name,
        String attribute5Value,
        Integer attribute5Visible,
        Integer attribute5Global,
        String attribute5Default
    ) {
        this.type = type;
        this.sku = sku;
        this.name = name;
        this.published = published;
        this.isFeatured = isFeatured;
        this.visibilityInCatalog = visibilityInCatalog;
        this.shortDescription = shortDescription;
        this.description = description;
        this.dateSalePriceStarts = dateSalePriceStarts;
        this.dateSalePriceEnds = dateSalePriceEnds;
        this.taxStatus = taxStatus;
        this.taxClass = taxClass;
        this.inStock = inStock;
        this.stock = stock;
        this.lowStockAmount = lowStockAmount;
        this.backordersAllowed = backordersAllowed;
        this.soldIndividually = soldIndividually;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.allowCustomerReviews = allowCustomerReviews;
        this.purchaseNote = purchaseNote;
        this.salePrice = salePrice;
        this.regularPrice = regularPrice;
        this.categories = categories;
        this.tags = tags;
        this.shippingClass = shippingClass;
        this.images = images;
        this.downloadLimit = downloadLimit;
        this.downloadExpiryDays = downloadExpiryDays;
        this.parent = parent;
        this.groupedProducts = groupedProducts;
        this.upsells = upsells;
        this.crossSells = crossSells;
        this.externalUrl = externalUrl;
        this.buttonText = buttonText;
        this.position = position;
        this.attribute1Name = attribute1Name;
        this.attribute1Value = attribute1Value;
        this.attribute1Visible = attribute1Visible;
        this.attribute1Global = attribute1Global;
        this.attribute1Default = attribute1Default;
        this.attribute2Name = attribute2Name;
        this.attribute2Value = attribute2Value;
        this.attribute2Visible = attribute2Visible;
        this.attribute2Global = attribute2Global;
        this.attribute2Default = attribute2Default;
        this.attribute3Name = attribute3Name;
        this.attribute3Value = attribute3Value;
        this.attribute3Visible = attribute3Visible;
        this.attribute3Global = attribute3Global;
        this.attribute3Default = attribute3Default;
        this.attribute4Name = attribute4Name;
        this.attribute4Value = attribute4Value;
        this.attribute4Visible = attribute4Visible;
        this.attribute4Global = attribute4Global;
        this.attribute4Default = attribute4Default;
        this.attribute5Name = attribute5Name;
        this.attribute5Value = attribute5Value;
        this.attribute5Visible = attribute5Visible;
        this.attribute5Global = attribute5Global;
        this.attribute5Default = attribute5Default;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getPublished() { return published; }
    public void setPublished(Integer published) { this.published = published; }

    public Integer getIsFeatured() { return isFeatured; }
    public void setIsFeatured(Integer isFeatured) { this.isFeatured = isFeatured; }

    public String getVisibilityInCatalog() { return visibilityInCatalog; }
    public void setVisibilityInCatalog(String visibilityInCatalog) { this.visibilityInCatalog = visibilityInCatalog; }

    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getDateSalePriceStarts() { return dateSalePriceStarts; }
    public void setDateSalePriceStarts(Long dateSalePriceStarts) { this.dateSalePriceStarts = dateSalePriceStarts; }
    
    public Long getDateSalePriceEnds() { return dateSalePriceEnds; }
    public void setDateSalePriceEnds(Long dateSalePriceEnds) { this.dateSalePriceEnds = dateSalePriceEnds; }

    public String getTaxStatus() { return taxStatus; }
    public void setTaxStatus(String taxStatus) { this.taxStatus = taxStatus; }

    public String getTaxClass() { return taxClass; }
    public void setTaxClass(String taxClass) { this.taxClass = taxClass; }

    public Integer getInStock() { return inStock; }
    public void setInStock(Integer inStock) { this.inStock = inStock; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Integer getLowStockAmount() { return lowStockAmount; }
    public void setLowStockAmount(Integer lowStockAmount) { this.lowStockAmount = lowStockAmount; }

    public Integer getBackordersAllowed() { return backordersAllowed; }
    public void setBackordersAllowed(Integer backordersAllowed) { this.backordersAllowed = backordersAllowed; }

    public Integer getSoldIndividually() { return soldIndividually; }
    public void setSoldIndividually(Integer soldIndividually) { this.soldIndividually = soldIndividually; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    public Double getLength() { return length; }
    public void setLength(Double length) { this.length = length; }

    public Double getWidth() { return width; }
    public void setWidth(Double width) { this.width = width; }

    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }

    public Integer getAllowCustomerReviews() { return allowCustomerReviews; }
    public void setAllowCustomerReviews(Integer allowCustomerReviews) {
        this.allowCustomerReviews = allowCustomerReviews;
    }

    public String getPurchaseNote() { return purchaseNote; }
    public void setPurchaseNote(String purchaseNote) { this.purchaseNote = purchaseNote; }

    public Double getSalePrice() { return salePrice; }
    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getRegularPrice() { return regularPrice; }
    public void setRegularPrice(Double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public List<Category> getCategories() { return categories; }
    public void setCategories(List<Category> categories) { this.categories = categories; }

    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }

    public String getShippingClass() { return shippingClass; }
    public void setShippingClass(String shippingClass) { this.shippingClass = shippingClass; }

    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }

    public Integer getDownloadLimit() { return downloadLimit; }
    public void setDownloadLimit(Integer downloadLimit) {
        this.downloadLimit = downloadLimit;
    }

    public Integer getDownloadExpiryDays() { return downloadExpiryDays; }
    public void setDownloadExpiryDays(Integer downloadExpiryDays) {
        this.downloadExpiryDays = downloadExpiryDays;
    }

    public String getParent() { return parent; }
    public void setParent(String parent) { this.parent = parent; }

    public String getGroupedProducts() { return groupedProducts; }
    public void setGroupedProducts(String groupedProducts) { this.groupedProducts = groupedProducts; }

    public String getUpsells() { return upsells; }
    public void setUpsells(String upsells) { this.upsells = upsells; }

    public String getCrossSells() { return crossSells; }
    public void setCrossSells(String crossSells) { this.crossSells = crossSells; }

    public String getExternalUrl() { return externalUrl; }
    public void setExternalUrl(String externalUrl) { this.externalUrl = externalUrl; }

    public String getButtonText() { return buttonText; }
    public void setButtonText(String buttonText) { this.buttonText = buttonText; }

    public Integer getPosition() { return position; }
    public void setPosition(Integer position) { this.position = position; }

    public String getAttribute1Name() { return attribute1Name; }
    public void setAttribute1Name(String attribute1Name) { this.attribute1Name = attribute1Name; }

    public String getAttribute1Value() { return attribute1Value; }
    public void setAttribute1Value(String attribute1Value) { this.attribute1Value = attribute1Value; }

    public Integer getAttribute1Visible() { return attribute1Visible; }
    public void setAttribute1Visible(Integer attribute1Visible) { this.attribute1Visible = attribute1Visible; }

    public Integer getAttribute1Global() { return attribute1Global; }
    public void setAttribute1Global(Integer attribute1Global) { this.attribute1Global = attribute1Global; }

    public String getAttribute1Default() { return attribute1Default; }
    public void setAttribute1Default(String attribute1Default) { this.attribute1Default = attribute1Default; }

    public String getAttribute2Name() { return attribute2Name; }
    public void setAttribute2Name(String attribute2Name) { this.attribute2Name = attribute2Name; }

    public String getAttribute2Value() { return attribute2Value; }
    public void setAttribute2Value(String attribute2Value) { this.attribute2Value = attribute2Value; }

    public Integer getAttribute2Visible() { return attribute2Visible; }
    public void setAttribute2Visible(Integer attribute2Visible) { this.attribute2Visible = attribute2Visible; }

    public Integer getAttribute2Global() { return attribute2Global; }
    public void setAttribute2Global(Integer attribute2Global) { this.attribute2Global = attribute2Global; }

    public String getAttribute2Default() { return attribute2Default; }
    public void setAttribute2Default(String attribute2Default) { this.attribute2Default = attribute2Default; }

    public String getAttribute3Name() { return attribute3Name; }
    public void setAttribute3Name(String attribute3Name) { this.attribute3Name = attribute3Name; }

    public String getAttribute3Value() { return attribute3Value; }
    public void setAttribute3Value(String attribute3Value) { this.attribute3Value = attribute3Value; }

    public Integer getAttribute3Visible() { return attribute3Visible; }
    public void setAttribute3Visible(Integer attribute3Visible) { this.attribute3Visible = attribute3Visible; }

    public Integer getAttribute3Global() { return attribute3Global; }
    public void setAttribute3Global(Integer attribute3Global) { this.attribute3Global = attribute3Global; }

    public String getAttribute3Default() { return attribute3Default; }
    public void setAttribute3Default(String attribute3Default) { this.attribute3Default = attribute3Default; }

    public String getAttribute4Name() { return attribute4Name; }
    public void setAttribute4Name(String attribute4Name) { this.attribute4Name = attribute4Name; }

    public String getAttribute4Value() { return attribute4Value; }
    public void setAttribute4Value(String attribute4Value) { this.attribute4Value = attribute4Value; }

    public Integer getAttribute4Visible() { return attribute4Visible; }
    public void setAttribute4Visible(Integer attribute4Visible) { this.attribute4Visible = attribute4Visible; }

    public Integer getAttribute4Global() { return attribute4Global; }
    public void setAttribute4Global(Integer attribute4Global) { this.attribute4Global = attribute4Global; }

    public String getAttribute4Default() { return attribute4Default; }
    public void setAttribute4Default(String attribute4Default) { this.attribute4Default = attribute4Default; }

    public String getAttribute5Name() { return attribute5Name; }
    public void setAttribute5Name(String attribute5Name) { this.attribute5Name = attribute5Name; }

    public String getAttribute5Value() { return attribute5Value; }
    public void setAttribute5Value(String attribute5Value) { this.attribute5Value = attribute5Value; }

    public Integer getAttribute5Visible() { return attribute5Visible; }
    public void setAttribute5Visible(Integer attribute5Visible) { this.attribute5Visible = attribute5Visible; }

    public Integer getAttribute5Global() { return attribute5Global; }
    public void setAttribute5Global(Integer attribute5Global) { this.attribute5Global = attribute5Global; }

    public String getAttribute5Default() { return attribute5Default; }
    public void setAttribute5Default(String attribute5Default) { this.attribute5Default = attribute5Default; }
}
