package fr.idmc.sid.coursesmanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(unique=true)
    private String name;
    private Date date;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Student> students = new HashSet<>();
}