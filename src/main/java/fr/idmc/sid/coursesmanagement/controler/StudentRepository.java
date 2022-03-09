package fr.idmc.sid.coursesmanagement.controler;

import fr.idmc.sid.coursesmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}