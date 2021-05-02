package com.asgarov.qanda.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question extends AbstractPersistable<Long> {
    public static final int HEADING_WORD_COUNT = 13;
    public static final int NAV_HEADING_WORD_COUNT = 8;
    private String questionText;
    private LocalDateTime timeAsked;
    private boolean isAnswered;
    private String sessionId;

    @ManyToOne
    private Room room;

    public Question(String question, LocalDateTime timeAsked) {
        this.questionText = question;
        this.timeAsked = timeAsked;
    }

    public Question(String question, LocalDateTime timeAsked, Room room, String sessionId) {
        this.questionText = question;
        this.timeAsked = timeAsked;
        this.room = room;
        this.sessionId = sessionId;
    }

    public String getHeading() {
        String[] words = questionText.split(" ");
        if (words.length > HEADING_WORD_COUNT) {
            return Arrays.stream(words).limit(HEADING_WORD_COUNT).collect(Collectors.joining(" ")) + " ...";
        }
        return questionText;
    }

    public String getNavHeading() {
        String[] words = questionText.split(" ");
        if (words.length > NAV_HEADING_WORD_COUNT) {
            return Arrays.stream(words).limit(NAV_HEADING_WORD_COUNT).collect(Collectors.joining(" ")) + " ...";
        }
        return questionText;
    }
}
