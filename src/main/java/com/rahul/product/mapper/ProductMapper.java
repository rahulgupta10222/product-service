package com.rahul.product.mapper;

import java.math.BigDecimal;

import com.rahul.product.dto.ProductDto;
import com.rahul.product.entity.Product;

public class ProductMapper {
	
	public static ProductDto mapProductToProductDto(final Product product, final ProductDto productDto, final long shopId) {
		productDto.setName(product.getName());
		productDto.setQuantity(product.getQuantity().getOrDefault(shopId, BigDecimal.ZERO));
		productDto.setPurchasePrice(product.getPurchasePrice().getOrDefault(shopId, BigDecimal.ZERO));
		productDto.setSalesPrice(product.getSalesPrice().getOrDefault(shopId, BigDecimal.ZERO));
		return productDto;
	}
	
	public static Product mapProductDtoToProduct(final ProductDto productDto, final Product product, final long shopId) {
		product.setName(productDto.getName());
		product.getShopIds().add(shopId);
		product.getQuantity().put(shopId, productDto.getQuantity());
		product.getPurchasePrice().put(shopId, productDto.getPurchasePrice());
		product.getSalesPrice().put(shopId, productDto.getSalesPrice());
		return product;
	}

}
