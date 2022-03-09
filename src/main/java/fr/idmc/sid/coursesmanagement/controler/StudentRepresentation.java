package fr.idmc.sid.coursesmanagement.controler;

import fr.idmc.sid.coursesmanagement.WebSecurityConfig;
import fr.idmc.sid.coursesmanagement.entity.Course;
import fr.idmc.sid.coursesmanagement.entity.Room;
import fr.idmc.sid.coursesmanagement.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import java.net.URI;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
@ExposesResourceFor(Student.class)
@RequiredArgsConstructor
public class StudentRepresentation {
    private final StudentRepository studentRepository;
    private PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    // GET all
    @GetMapping
    @RolesAllowed("ROLE_USER")
    public ResponseEntity<?> listStudents() {
        System.out.println(WebSecurityConfig.currentUsername());
        return ResponseEntity.ok((studentRepository.findAll()));
    }

    @PostMapping
    @Transactional
    @RolesAllowed("ROLE_USER")
    public ResponseEntity<?> save(@RequestBody Student studentInput) {

        Set<Course> courses = new HashSet<>();


        String pwencoded = encoder.encode(studentInput.getPassword());
        Student student2save = new Student((UUID.randomUUID().toString()),studentInput.getNom(), studentInput.getPrenom(), studentInput.getEmail(), pwencoded, courses);
        studentRepository.save(student2save);
        URI location = linkTo(RoomRepository.class).slash(student2save.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
