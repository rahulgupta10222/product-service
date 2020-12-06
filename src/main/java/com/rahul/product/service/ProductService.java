package com.rahul.product.service;

import java.util.List;

import com.rahul.product.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getProductsByShopId(final long shopId);
	
	List<ProductDto> getProducts();
	
	ProductDto create(final ProductDto productDto, final long shopId);
}
