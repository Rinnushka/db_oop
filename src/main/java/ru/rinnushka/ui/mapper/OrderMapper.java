package ru.rinnushka.ui.mapper;

import lombok.experimental.UtilityClass;
import ru.rinnushka.ui.dto.OrderCreateUpdateDto;
import ru.rinnushka.ui.entity.Employee;
import ru.rinnushka.ui.entity.Order;

@UtilityClass
public class OrderMapper {
    public Order fromDto(OrderCreateUpdateDto dto, Employee employee) {
        return Order.builder()
                .orderNumber(dto.getOrderNumber())
                .orderDate(dto.getOrderDate())
                .contentOrder(dto.getContentOrder())
                .issuingAuthorityOrder(dto.getIssuingAuthorityOrder())
                .employee(employee)
                .build();
    }

    public Order update(OrderCreateUpdateDto dto, Order fromDb, Employee employee) {
        fromDb.setOrderNumber(dto.getOrderNumber());
        fromDb.setOrderDate(dto.getOrderDate());
        fromDb.setContentOrder(dto.getContentOrder());
        fromDb.setIssuingAuthorityOrder(dto.getIssuingAuthorityOrder());
        fromDb.setEmployee(employee);
        return fromDb;
    }
}
