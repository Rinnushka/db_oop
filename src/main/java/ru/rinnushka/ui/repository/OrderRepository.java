package ru.rinnushka.ui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.rinnushka.ui.entity.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderByIdDesc();

    @Query("from Order where " +
            "lower(contentOrder) like concat('%',:filter,'%') or " +
            "lower(orderNumber) like concat('%',:filter,'%') or " +
            "lower(issuingAuthorityOrder) like concat('%',:filter,'%') or " +
            "lower(concat(employee.lastName,' ',employee.firstName,' ',employee.secondName)) like concat('%',:filter,'%') " +
            "order by orderDate desc"
    )
    List<Order> findAllWithFilter(String filter);
}
