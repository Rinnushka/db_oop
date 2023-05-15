package ru.rinnushka.ui.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ru.rinnushka.ui.entity.Employee;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCreateUpdateDto {

    @NotBlank @NotNull
    private String orderNumber;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    private LocalDate orderDate;

    @NotBlank @NotNull
    private String contentOrder;

    @NotBlank @NotNull
    private String issuingAuthorityOrder;

    @NotNull
    private EmployeeDto employee;
}
