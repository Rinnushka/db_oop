package ru.rinnushka.ui.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(schema = "web_ui", name = "office")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Office {
    @Id
    @SequenceGenerator(name = "seq_office", sequenceName = "seq_office", allocationSize = 1, initialValue = 30)
    @GeneratedValue(generator = "seq_office", strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

    @ManyToMany
    @JoinTable(schema = "web_ui", name = "notarial_office",
            joinColumns = @JoinColumn(name = "id_office"),
            inverseJoinColumns = @JoinColumn(name = "id_employee"))
    private List<Employee> employees;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "house", nullable = false)
    private Integer house;

    @Column(name = "room", nullable = false)
    private Integer room;

    @Column(name = "telephone", nullable = false)
    private Integer telephone;

    @Column(name = "residential", nullable = false)
    private Boolean residential;

    @Column(name = "flor", nullable = false)
    private Integer flor;

    @Column(name = "ramp", nullable = false)
    private Boolean ramp;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "dining_room", nullable = false)
    private Boolean diningRoom;

    @Column(name = "rest_room", nullable = false)
    private Boolean restRoom;

    @Column(name = "sanitary_room", nullable = false)
    private Boolean sanitaryRoom;

    @Column(name = "year_of_repair", nullable = false)
    private LocalDate yearOfRepair;

    @Column(name = "number_of_computers", nullable = false)
    private Integer numberOfComputers;
}