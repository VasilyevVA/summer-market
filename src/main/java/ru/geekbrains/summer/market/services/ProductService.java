package ru.geekbrains.summer.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    public void saveNewProduct(String title, int price) {
        Product product = new Product(null, title, price);
        if (product.getPrice() <= 0) {
            return;
        }
        productRepository.save(product);
    }
}
