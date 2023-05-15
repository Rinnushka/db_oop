package ru.rinnushka.ui.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(schema = "web_ui", name = "license")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class License {
    @Id
    @SequenceGenerator(name = "seq_license", sequenceName = "seq_license", allocationSize = 1, initialValue = 30)
    @GeneratedValue(generator = "seq_license", strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "number_license", nullable = false)
    private Integer numberLicense;

    @Column(name = "date_of_issue", nullable = false)
    private LocalDate dateOfIssue;

    @Column(name = "issuing_authority", nullable = false)
    private String issuingAuthority;

    @Column(name = "terminated", nullable = false)
    private Boolean terminated;

    @OneToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @Column(name = "status", nullable = false)
    private Boolean status;
}