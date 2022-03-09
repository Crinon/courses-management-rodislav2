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
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
@ExposesResourceFor(Room.class)
@RequiredArgsConstructor
public class RoomRepresentation {
    private final RoomRepository roomRepository;

    // GET all
    @GetMapping
    @RolesAllowed("ROLE_USER")
    public ResponseEntity<?> listRooms() {
        System.out.println(WebSecurityConfig.currentUsername());
        return ResponseEntity.ok((roomRepository.findAll()));
    }

    @PostMapping
    @Transactional
    @RolesAllowed("ROLE_USER")
    public ResponseEntity<?> save(@RequestBody Room roomInput) {
        Room room2save = new Room((UUID.randomUUID().toString()),roomInput.getNumber(), roomInput.getCapacity());
        roomRepository.save(room2save);
        URI location = linkTo(RoomRepository.class).slash(room2save.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
