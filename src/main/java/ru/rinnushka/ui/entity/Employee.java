package ru.rinnushka.ui.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(schema = "web_ui", name = "employee")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @SequenceGenerator(name = "seq_emloyee", sequenceName = "seq_emloyee", allocationSize = 1, initialValue = 30)
    @GeneratedValue(generator = "seq_emloyee", strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate birthday;

    @Column(name = "education", nullable = false)
    private String education;
}
