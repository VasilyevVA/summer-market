package ru.geekbrains.summer.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.summer.market.dto.ProductDto;
import ru.geekbrains.summer.market.exception_handling.ResourceNotFoundException;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.model.User;
import ru.geekbrains.summer.market.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServices {
    private final UserRepository repository;

    public Optional<User> findProductById(Long id) {
        return repository.findById(id);
    }

    public List<User> findAllProduct() {
        return repository.findAll();
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User saveOrUpdate(User user) {
        return repository.save(user);
    }

    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }
}