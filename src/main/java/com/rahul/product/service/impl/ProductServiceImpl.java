package com.rahul.product.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.product.dto.ProductDto;
import com.rahul.product.entity.Product;
import com.rahul.product.mapper.ProductMapper;
import com.rahul.product.repository.ProductRepository;
import com.rahul.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<ProductDto> getProductsByShopId(final long shopId) {
		final List<Product> products = this.productRepository.findAll();
		final List<Product> localProducts = products.stream().filter(product -> product.getShopIds().contains(shopId)).collect(Collectors.toList());
		return localProducts.stream().map(product -> ProductMapper.mapProductToProductDto(product, new ProductDto(), shopId)).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getProducts() {
		final List<Product> products = this.productRepository.findAll();
		return products.stream().map(product -> ProductMapper.mapProductToProductDto(product, new ProductDto(),0)).collect(Collectors.toList());
	}

	@Override
	public ProductDto create(final ProductDto productDto, final long shopId) {
		final String productName = productDto.getName().trim();
		productDto.setName(productName);
		Optional<Product> productOptional =  this.productRepository.findByName(productName);
		final Product product = ProductMapper.mapProductDtoToProduct(productDto, productOptional.isPresent() ? productOptional.get() : new Product(), shopId);;
//		if(productOptional.isPresent()) {
//			product = ProductMapper.mapProductDtoToProduct(productDto, productOptional.get(), shopId);
//		}
//		else {
//			product = ProductMapper.mapProductDtoToProduct(productDto, new Product(), shopId);
//		}
		return ProductMapper.mapProductToProductDto(this.productRepository.save(product), productDto, shopId);
	}

}
