package ru.geekbrains.summer.market.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.services.ProductServices;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@RequiredArgsConstructor
@Data
public class Cart {

    private final ProductServices services;
    private Map<Product, Integer> itemsMap;
    private int totalPrice;

    @PostConstruct
    public void init() {
        this.itemsMap = new HashMap<>();
    }

    public List<String> viewCartProductList() {
        List<String> list = new ArrayList<>();
        for (Map.Entry<Product, Integer> product : itemsMap.entrySet()) {
            list.add(product.getKey() + ", " + product.getValue());
        }
        return list;
    }

    public void addProductToCart(Long id) {
        Product p = getProductById(id);

        itemsMap.compute(p, (product, integer) -> integer  == null ? 1 : ++integer);
    }

    public void removeProductFromCart(Long id) {
        Product p = getProductById(id);
        itemsMap.computeIfPresent(p, (product, integer) -> --integer);
    }

    public void clear() {
        itemsMap.clear();
    }

    private Product getProductById(Long id) {
        Product p = services.findProductById(id).map(Product::new).get();
        return p;
    }
}