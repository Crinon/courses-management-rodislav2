package fr.idmc.sid.coursesmanagement.controler;

import fr.idmc.sid.coursesmanagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}