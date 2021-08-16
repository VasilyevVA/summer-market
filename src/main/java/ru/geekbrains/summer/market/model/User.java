package ru.geekbrains.summer.market.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.geekbrains.summer.market.dto.ProductDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", length = 50)
    private String name;

    @Column(name = "password", length = 100)
    private String surname;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public User(ProductDto productDto) {
//        this.id = productDto.getId();
//        this.title = productDto.getTitle();
//        this.price = productDto.getPrice();
    }
}