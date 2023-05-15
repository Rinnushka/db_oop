package ru.rinnushka.ui.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rinnushka.ui.dto.OrderCreateUpdateDto;
import ru.rinnushka.ui.entity.Employee;
import ru.rinnushka.ui.entity.Order;
import ru.rinnushka.ui.mapper.OrderMapper;
import ru.rinnushka.ui.service.EmployeeService;
import ru.rinnushka.ui.service.OrderService;
import ru.rinnushka.ui.utils.AppUtils;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final AppUtils appUtils;
    private final OrderService service;
    private final EmployeeService employeeService;

    @GetMapping("/list")
    public String findAll(Model model) {
        appUtils.addBaseUrlToModel(model);
        addNotesToModel(model);
        return "orders";
    }

    @PostMapping("/filter")
    public String findAll(Model model, String filter) {
        appUtils.addBaseUrlToModel(model);
        addNotesToModel(model, filter);
        return "orders";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        appUtils.addBaseUrlToModel(model);
        addEmployeesToModel(model);
        return "order_create";
    }

    @PostMapping("/create")
    public String create(Model model, @Valid OrderCreateUpdateDto orderDto) {
        Order order = OrderMapper.fromDto(orderDto, employeeService.findById(orderDto.getEmployee().getId()));
        order = service.save(order);
        appUtils.addBaseUrlToModel(model);
        addOrderToModel(model, order);
        addEmployeesToModel(model);
        return "order_card";
    }

    @GetMapping("/order/{id}")
    public String orderCard(Model model, @PathVariable Long id) {
        appUtils.addBaseUrlToModel(model);
        addOrderToModel(model, service.findById(id));
        addEmployeesToModel(model);
        return "order_card";
    }

    @PostMapping("/order/{id}/update")
    public String update(Model model, @Valid OrderCreateUpdateDto orderDto, @PathVariable Long id) {
        Order order = OrderMapper.update(
                orderDto,
                service.findById(id),
                employeeService.findById(orderDto.getEmployee().getId())
        );
        order = service.save(order);
        appUtils.addBaseUrlToModel(model);
        addOrderToModel(model, order);
        addEmployeesToModel(model);
        return "order_card";
    }

    @GetMapping("/order/{id}/delete")
    public String update(Model model, @PathVariable Long id) {
        service.delete(id);
        appUtils.addBaseUrlToModel(model);
        addNotesToModel(model);
        return "orders";
    }

    private void addNotesToModel(Model model) {
        List<Order> orders = service.findAll();
        model.addAttribute("orders", orders);
    }

    private void addNotesToModel(Model model, String filter) {
        List<Order> orders = service.findAll(filter);
        model.addAttribute("orders", orders);
        model.addAttribute("filter", filter);
    }

    private void addEmployeesToModel(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
    }

    private void addOrderToModel(Model model, Order order) {
        model.addAttribute("order", order);
    }

//    private void addNotesToModel(Model model, String filter) {
//        val filtered = service.search(filter)
//        model.addAttribute("notes", filtered)
//        model.addAttribute("filter", filter)
//    }
}
