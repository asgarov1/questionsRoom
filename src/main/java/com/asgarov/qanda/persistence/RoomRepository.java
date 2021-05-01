package com.asgarov.qanda.persistence;

import com.asgarov.qanda.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    Optional<Room> findByName(String roomName);

    long countByName(String roomName);
}
