package ru.geekbrains.summer.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.summer.market.model.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    List<Product> findAllByPriceIsGreaterThanEqual(Integer price);

    List<Product> findAllByPriceIsLessThanEqual(Integer price);

    List<Product> findAllByPriceBetween(Integer min, Integer max);

    @Query("select p from Product p where p.price = :price")
    List<Product> customQueryOne(int price);

    @Query("select p from Product p where p.id = ?1 and p.name = ?2")
    Optional<Product> customQuerySecond(Long id, String name);

}