package com.rahul.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.product.dto.ProductDto;
import com.rahul.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> getGlobalProducts(){
		return new ResponseEntity<>(this.productService.getProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<ProductDto>> getLocalProducts(@RequestParam("shopId") final long shopId){
		return new ResponseEntity<>(this.productService.getProductsByShopId(shopId),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ProductDto> createProduct(@RequestBody final ProductDto productDto, @RequestParam("shopId") final long shopId){
		return new ResponseEntity<>(this.productService.create(productDto, shopId), HttpStatus.CREATED);
	}
}
