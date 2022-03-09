package fr.idmc.sid.coursesmanagement.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
    private Date date;
}