package com.asgarov.qanda.service;

import com.asgarov.qanda.domain.Question;
import com.asgarov.qanda.domain.Room;
import com.asgarov.qanda.persistence.RoomRepository;
import com.asgarov.qanda.util.WordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.asgarov.qanda.util.WordGenerator.generateAlphabetic;

@Service
public class RoomService {

    public static final int WORD_LENGTH = 6;
    @Autowired
    private RoomRepository repository;

    public List<Question> getQuestionsForRoom(String roomName){
        return repository.findByName(roomName).map(Room::getQuestions).orElse(new ArrayList<>());
    }

    public Room createRoom() {
        String name = generateAvailableName();
        Room room = new Room(name);
        repository.save(room);
        return room;
    }

    private String generateAvailableName() {
        String name = generateAlphabetic(WORD_LENGTH);
        while (repository.countByName(name) != 0) {
            name = generateAlphabetic(WORD_LENGTH);
        }
        return name;
    }

    public Room getRoom(String roomName) {
        return repository.findByName(roomName)
                .orElseGet(() -> repository.save(new Room(roomName)));
    }

    public void save(Room room) {
        repository.save(room);
    }
}
