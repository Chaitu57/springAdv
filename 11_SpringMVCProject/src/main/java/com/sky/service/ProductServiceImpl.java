package com.sky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.domain.Product;
import com.sky.repository.ProductRespository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRespository productRespository;
	
	@Override
	public void addProduct(Product product) {
		System.out.println("in repository");
		if(product.getPrice()>20)
			productRespository.addProduct(product);
		
	}

	@Override
	public List<Product> getProducts() {
		
		
		return productRespository.getProducts();
	}




	
}
