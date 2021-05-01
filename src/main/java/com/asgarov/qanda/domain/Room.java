package com.asgarov.qanda.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Room extends AbstractPersistable<Long> {
    private String name;

    @OneToMany(mappedBy = "room")
    private List<Question> questions = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}
