package ru.geekbrains.summer.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void getProductRepository (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct (Product product) {
        productRepository.addProduct(product);
    }

    public void deleteProduct (long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllProduct () {
        return productRepository.getList();
    }
}