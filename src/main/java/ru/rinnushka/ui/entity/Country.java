package ru.rinnushka.ui.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(schema = "web_ui", name = "country")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country {
    @Id
    @SequenceGenerator(name = "seq_country", sequenceName = "seq_country", allocationSize = 1, initialValue = 30)
    @GeneratedValue(generator = "seq_country", strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "locality", nullable = false)
    private String locality;

    @Column(name = "district", nullable = false)
    private String district;
}
