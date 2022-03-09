package fr.idmc.sid.coursesmanagement.controler;

import fr.idmc.sid.coursesmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByPrenomEqualsIgnoreCase(String prenom);

}