package fr.idmc.sid.coursesmanagement.controler;

import fr.idmc.sid.coursesmanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}