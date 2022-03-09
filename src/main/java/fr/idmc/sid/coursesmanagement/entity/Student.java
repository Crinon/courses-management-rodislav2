package fr.idmc.sid.coursesmanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Course> courses = new HashSet<>();
}
