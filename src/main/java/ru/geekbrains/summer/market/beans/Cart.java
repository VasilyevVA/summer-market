package ru.geekbrains.summer.market.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.summer.market.exception_handling.ResourceNotFoundException;
import ru.geekbrains.summer.market.model.OrderItem;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.services.ProductServices;

import javax.annotation.PostConstruct;
import java.util.*;


@Component
@RequiredArgsConstructor
@Data
public class Cart {

    private final ProductServices services;
    private List<OrderItem> items;
    private int totalPrice;

    @PostConstruct
    public void init() {
        this.items = new ArrayList<>();
    }

    public List<String> viewCartProductList() {
        List<String> list = new ArrayList<>();
        return list;
    }

    public void addToCart(Long id) {
        for (OrderItem orderItem : items) {
            if (orderItem.getProduct().getId().equals(id)) {
                orderItem.incrementQuantity();
                reCount();
                return;
            }
        }
        Product product = services.findProductById(id).orElseThrow(() ->
                new ResourceNotFoundException(
                        "The product was not added to the cart because it was not found by id: "
                                + id));
        OrderItem orderItem = new OrderItem(product);
        items.add(orderItem);
        reCount();
    }

    public void removeProductFromCart(Long id) {
        Product p = services.findProductById(id).get();
    }

    public void clear() {
        items.clear();
        reCount();
    }

    public void reCount() {
        totalPrice = 0;
        for (OrderItem orderItem : items) {
            totalPrice += orderItem.getPrice();
        }
    }

}