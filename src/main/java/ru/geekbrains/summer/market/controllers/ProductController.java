package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.services.ProductServices;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServices services;

    @GetMapping
    public List<Product> findAllProducts(
            @RequestParam(name = "min_price", defaultValue = "0") Integer minPrice,
            @RequestParam(name = "max_price", required = false) Integer maxPrice
    ) {
        if (maxPrice == null) {
            maxPrice = Integer.MAX_VALUE;
        }
        return services.findAllByPrice(minPrice, maxPrice);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return services.findProductById(id).get();
    }

    @PostMapping
    public Product saveNewProduct(@RequestBody Product product) {
        product.setId(null);
        return services.saveOrUpdate(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        services.deleteProductById(id);
    }
}