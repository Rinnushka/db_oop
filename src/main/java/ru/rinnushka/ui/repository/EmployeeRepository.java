package ru.rinnushka.ui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rinnushka.ui.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
