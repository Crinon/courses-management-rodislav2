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
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private int number;
    private int capacity;
}
