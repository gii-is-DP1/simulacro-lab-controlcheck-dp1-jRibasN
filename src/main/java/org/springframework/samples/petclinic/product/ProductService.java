package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired(required = true)
	public ProductService(ProductRepository ProductRepository) {
		this.productRepository = ProductRepository;
	}
    
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<ProductType> getAllProductsType(){
        return productRepository.findAllProductTypes();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return productRepository.findPTypeByName(typeName);
    }

    @Transactional
	public void saveUser(Product p) throws DataAccessException {
		productRepository.save(p);
	}

    
}
