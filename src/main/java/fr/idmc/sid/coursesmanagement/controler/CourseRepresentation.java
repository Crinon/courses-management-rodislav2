package fr.idmc.sid.coursesmanagement.controler;


import fr.idmc.sid.coursesmanagement.WebSecurityConfig;
import fr.idmc.sid.coursesmanagement.entity.Course;
import fr.idmc.sid.coursesmanagement.entity.Room;
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
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

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
        String sDate6 = "31-12-1998 23:37:50";
        SimpleDateFormat formatter6=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date6=formatter6.parse(sDate6);
        System.out.println(sDate6+"\t"+date6);
        Date date = input.getDate();

        Course course2save = new Course((UUID.randomUUID().toString()),input.getName(), input.getDate());
        courseRepository.save(course2save);
        URI location = linkTo(RoomRepository.class).slash(course2save.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
