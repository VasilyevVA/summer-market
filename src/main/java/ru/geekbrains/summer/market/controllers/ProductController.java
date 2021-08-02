package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repositories.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @GetMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @GetMapping("/search_by_name")
    public Product findByName(@RequestParam String name) {
        return productRepository.findByName(name).get();
    }

    @GetMapping("/search_by_min_price")
    public List<Product> searchByMinPrice(@RequestParam Integer minPrice) {
        return productRepository.findAllByPriceIsGreaterThanEqual(minPrice);
    }

    @GetMapping("/search_by_max_price")
    public List<Product> searchByMaxPrice(@RequestParam Integer maxPrice) {
        return productRepository.findAllByPriceIsLessThanEqual(maxPrice);
    }

    @GetMapping("/search_by_between")
    public List<Product> searchByBetween(@RequestParam Integer min, Integer max) {
        return productRepository.findAllByPriceBetween(min, max);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    @GetMapping("/customQueryOne")
    public List<Product> customQueryOne(@RequestParam int price) {
        return productRepository.customQueryOne(price);
    }

    @GetMapping("/customQuerySecond")
    public Product customQueryOne(@RequestParam Long id, String name) {
        return productRepository.customQuerySecond(id, name).get();
    }
}