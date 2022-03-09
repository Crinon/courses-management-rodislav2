package fr.idmc.sid.coursesmanagement.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
}
