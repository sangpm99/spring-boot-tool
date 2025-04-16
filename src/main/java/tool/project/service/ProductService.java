package tool.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tool.project.model.Product;
import tool.project.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Map<String, Object> getProducts(int pageIndex, int pageSize, String searchValue, Long categoryId) {
        int offset = (pageIndex - 1) * pageSize;

        List<Product> items;
        int itemsCount;

        if (searchValue != null && !searchValue.isEmpty() && categoryId != null) {
            items = productRepository.searchByNameAndCategory(searchValue, categoryId, pageSize, offset);
            itemsCount = productRepository.countByNameAndCategory(searchValue, categoryId);
        } else if (searchValue != null && !searchValue.isEmpty()) {
            items = productRepository.searchByName(searchValue, pageSize, offset);
            itemsCount = productRepository.countByName(searchValue);
        } else if (categoryId != null) {
            items = productRepository.searchByCategory(categoryId, pageSize, offset);
            itemsCount = productRepository.countByCategory(categoryId);
        } else {
            items = productRepository.getAllProducts(pageSize, offset);
            itemsCount = productRepository.countAllProducts();
        }

        Map<String, Object> result = new HashMap<>();
        result.put("pageIndex", pageIndex);
        result.put("pageSize", pageSize);
        result.put("itemsCount", itemsCount);
        result.put("items", items);

        return result;
    }


    public void createProducts(List<Product> products) {
        Product currentVariable = null;

        for (Product product : products) {
            if ("variable".equalsIgnoreCase(product.getType())) {
            // Lưu bản ghi variable và nhớ ID
            productRepository.save(product);
            currentVariable = product; // bản ghi variable gần nhất
        } else if ("variation".equalsIgnoreCase(product.getType())) {
            if (currentVariable != null) {
                product.setParent("id:" + currentVariable.getId());
            }
            productRepository.save(product);
        } else {
            // Kiểu khác thì cứ save như thường
            productRepository.save(product);
        }
        }
    }

    public void updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setType(updatedProduct.getType());
            existingProduct.setSku(updatedProduct.getSku());
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPublished(updatedProduct.getPublished());
            existingProduct.setIsFeatured(updatedProduct.getIsFeatured());
            existingProduct.setVisibilityInCatalog(updatedProduct.getVisibilityInCatalog());
            existingProduct.setShortDescription(updatedProduct.getShortDescription());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setDateSalePriceStarts(updatedProduct.getDateSalePriceStarts());
            existingProduct.setDateSalePriceEnds(updatedProduct.getDateSalePriceEnds());
            existingProduct.setTaxStatus(updatedProduct.getTaxStatus());
            existingProduct.setTaxClass(updatedProduct.getTaxClass());
            existingProduct.setInStock(updatedProduct.getInStock());
            existingProduct.setStock(updatedProduct.getStock());
            existingProduct.setLowStockAmount(updatedProduct.getLowStockAmount());
            existingProduct.setBackordersAllowed(updatedProduct.getBackordersAllowed());
            existingProduct.setSoldIndividually(updatedProduct.getSoldIndividually());
            existingProduct.setWeight(updatedProduct.getWeight());
            existingProduct.setLength(updatedProduct.getLength());
            existingProduct.setWidth(updatedProduct.getWidth());
            existingProduct.setHeight(updatedProduct.getHeight());
            existingProduct.setAllowCustomerReviews(updatedProduct.getAllowCustomerReviews());
            existingProduct.setPurchaseNote(updatedProduct.getPurchaseNote());
            existingProduct.setSalePrice(updatedProduct.getSalePrice());
            existingProduct.setRegularPrice(updatedProduct.getRegularPrice());
            existingProduct.setCategories(updatedProduct.getCategories());
            existingProduct.setTags(updatedProduct.getTags());
            existingProduct.setShippingClass(updatedProduct.getShippingClass());
            existingProduct.setImages(updatedProduct.getImages());
            existingProduct.setDownloadLimit(updatedProduct.getDownloadLimit());
            existingProduct.setDownloadExpiryDays(updatedProduct.getDownloadExpiryDays());
            existingProduct.setParent(updatedProduct.getParent());
            existingProduct.setGroupedProducts(updatedProduct.getGroupedProducts());
            existingProduct.setUpsells(updatedProduct.getUpsells());
            existingProduct.setCrossSells(updatedProduct.getCrossSells());
            existingProduct.setExternalUrl(updatedProduct.getExternalUrl());
            existingProduct.setButtonText(updatedProduct.getButtonText());
            existingProduct.setPosition(updatedProduct.getPosition());
            existingProduct.setAttribute1Name(updatedProduct.getAttribute1Name());
            existingProduct.setAttribute1Value(updatedProduct.getAttribute1Value());
            existingProduct.setAttribute1Visible(updatedProduct.getAttribute1Visible());
            existingProduct.setAttribute1Global(updatedProduct.getAttribute1Global());
            existingProduct.setAttribute1Default(updatedProduct.getAttribute1Default());
            existingProduct.setAttribute2Name(updatedProduct.getAttribute2Name());
            existingProduct.setAttribute2Value(updatedProduct.getAttribute2Value());
            existingProduct.setAttribute2Visible(updatedProduct.getAttribute2Visible());
            existingProduct.setAttribute2Global(updatedProduct.getAttribute2Global());
            existingProduct.setAttribute2Default(updatedProduct.getAttribute2Default());
            existingProduct.setAttribute3Name(updatedProduct.getAttribute3Name());
            existingProduct.setAttribute3Value(updatedProduct.getAttribute3Value());
            existingProduct.setAttribute3Visible(updatedProduct.getAttribute3Visible());
            existingProduct.setAttribute3Global(updatedProduct.getAttribute3Global());
            existingProduct.setAttribute3Default(updatedProduct.getAttribute3Default());
            existingProduct.setAttribute4Name(updatedProduct.getAttribute4Name());
            existingProduct.setAttribute4Value(updatedProduct.getAttribute4Value());
            existingProduct.setAttribute4Visible(updatedProduct.getAttribute4Visible());
            existingProduct.setAttribute4Global(updatedProduct.getAttribute4Global());
            existingProduct.setAttribute4Default(updatedProduct.getAttribute4Default());
            existingProduct.setAttribute5Name(updatedProduct.getAttribute5Name());
            existingProduct.setAttribute5Value(updatedProduct.getAttribute5Value());
            existingProduct.setAttribute5Visible(updatedProduct.getAttribute5Visible());
            existingProduct.setAttribute5Global(updatedProduct.getAttribute5Global());
            existingProduct.setAttribute5Default(updatedProduct.getAttribute5Default());
            productRepository.save(existingProduct);
        }
    }

    public void deleteProducts(List<Long> ids) {
        productRepository.deleteAllById(ids);
    }

    public List<Product> exportProducts(Integer quantity, Long categoryId, boolean random) {
        if (categoryId != null && quantity != null && random) {
            return productRepository.getRandomVariableAndVariationsByCategory(categoryId, quantity);
        }
    
        return productRepository.findAll();
    }
    
}
