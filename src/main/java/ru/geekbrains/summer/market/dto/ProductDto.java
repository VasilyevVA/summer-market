package ru.geekbrains.summer.market.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.summer.market.model.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    @ApiModelProperty(value = "An identification number")
    private Long id;
    @ApiModelProperty(value = "the product's name")
    private String title;
    @ApiModelProperty(value = "Product price")
    private int price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }
}