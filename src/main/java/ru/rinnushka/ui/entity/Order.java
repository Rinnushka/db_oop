package ru.rinnushka.ui.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(schema = "web_ui", name = "order")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @SequenceGenerator(name = "seq_entities", sequenceName = "seq_entities", allocationSize = 1, initialValue = 30)
    @GeneratedValue(generator = "seq_entities", strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "order_number", nullable = false)
    private String orderNumber;

    @Column(name = "order_date", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate orderDate;

    @Column(name = "content_order", nullable = false)
    private String contentOrder;

    @Column(name = "issuing_authority_order", nullable = false)
    private String issuingAuthorityOrder;

    @Column(name = "start_date", nullable = false)
    @Builder.Default
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;
}
