package ru.geekbrains.summer.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import ru.geekbrains.summer.market.dto.ProductDto;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServices {
    private final ProductRepository repository;

    public Optional<ProductDto> findProductDtoById(Long id) {
        return repository.findById(id).map(ProductDto::new);
    }

    public Optional<Product> findProductById(Long id) {
        return repository.findById(id);
    }

    public List<Product> findAllProduct() {
        return repository.findAll();
    }

    public Page<ProductDto> findAll(Specification<Product> spec, int page, int pageSize) {
        return repository.findAll(spec, PageRequest.of(page - 1, pageSize)).map(ProductDto::new);
    }

    public Product saveOrUpdate(Product product) {
        return repository.save(product);
    }

    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }
}