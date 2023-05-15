package ru.rinnushka.ui.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rinnushka.ui.entity.Order;
import ru.rinnushka.ui.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;

    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return repository.findByOrderByIdDesc();
    }

    @Transactional(readOnly = true)
    public List<Order> findAll(String filter) {
        return repository.findAllWithFilter(filter.toLowerCase());
    }

    @Transactional(readOnly = true)
    public Order findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    public Order save(Order order) {
        return repository.save(order);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

