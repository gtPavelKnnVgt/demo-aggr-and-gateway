package cqrs.my.demo.course.aggr.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patient_details")
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "fio")
    private String fio;
    @Column(name = "user_id")
    private String userExternalId;
    @Column(name = "birth")
    private LocalDate birth;
    @Column(name = "address")
    private String address;
    @JoinColumn(name = "patient_details_id")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PatientAllergy> allergies;
    @JoinColumn(name = "patient_details_id")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PatientMedications> medications;
}
