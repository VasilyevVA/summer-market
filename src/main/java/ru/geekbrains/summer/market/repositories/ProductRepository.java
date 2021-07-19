package ru.geekbrains.summer.market.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.utils.ResourceNotFoundException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> items;

    @PostConstruct
    public void init() {
        this.items = new ArrayList<>(Arrays.asList(
                new Product(1L, "Milk", 85),
                new Product(2L, "Bread", 28),
                new Product(3L, "Cheese", 450)
        ));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(items);
    }

    public Product findById(Long id) {
//        return items.stream()
//                .filter(p -> p.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new ResourceNotFoundException());
        for (Product p : items) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw new ResourceNotFoundException();
    }

    public void save(Product product) {
        product.setId(items.stream().mapToLong(Product::getId).max().getAsLong() + 1L);
        items.add(product);
    }
}
