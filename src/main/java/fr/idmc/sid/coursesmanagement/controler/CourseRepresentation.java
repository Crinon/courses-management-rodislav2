package fr.idmc.sid.coursesmanagement.controler;


import fr.idmc.sid.coursesmanagement.WebSecurityConfig;
import fr.idmc.sid.coursesmanagement.entity.Course;
import fr.idmc.sid.coursesmanagement.entity.Room;
import fr.idmc.sid.coursesmanagement.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
@ExposesResourceFor(Course.class)
@RequiredArgsConstructor
public class CourseRepresentation {
    private final CourseRepository courseRepository;

    // GET all
    @GetMapping
    @RolesAllowed("ROLE_USER")
    public ResponseEntity<?> listCourses() {
        System.out.println(WebSecurityConfig.currentUsername());
        return ResponseEntity.ok((courseRepository.findAll()));
    }

    @PostMapping
    @Transactional
    @RolesAllowed("ROLE_USER")
    public ResponseEntity<?> save(@RequestBody Course input) throws ParseException {
        Set<Student> students = new HashSet<>();
        Course course2save = new Course((UUID.randomUUID().toString()),input.getName(),input.getDate(),students);
        courseRepository.save(course2save);
        URI location = linkTo(RoomRepository.class).slash(course2save.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
