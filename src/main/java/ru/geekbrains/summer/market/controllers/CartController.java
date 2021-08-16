package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.beans.Cart;
import ru.geekbrains.summer.market.services.ProductServices;

import java.util.List;

 /*
    http://localhost:8190/market/api/v2/cart/
    http://localhost:8190/market/api/v2/cart/all
    http://localhost:8190/market/api/v2/cart/add/10
    http://localhost:8190/market/api/v2/cart/delete/10
*/

@RestController
@RequestMapping("/api/v2/cart")
@RequiredArgsConstructor
public class CartController {
    private final ProductServices services;
    private final Cart cart;

    @GetMapping
    public Cart getCart() {
        return cart;
    }

    @GetMapping("/all")
    public List allItemsToCart() {
        return cart.viewCartProductList();
    }

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cart.addProductToCart(id);
    }


    @GetMapping("/delete/{id}")
    public void removeByIdFromCart(@PathVariable Long id) {
        cart.removeProductFromCart(id);
    }

    @GetMapping("/clear")
    public void clearCart() {
        cart.clear();
    }
}