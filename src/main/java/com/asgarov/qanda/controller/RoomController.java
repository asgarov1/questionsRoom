package com.asgarov.qanda.controller;

import com.asgarov.qanda.domain.Question;
import com.asgarov.qanda.domain.Room;
import com.asgarov.qanda.service.QuestionService;
import com.asgarov.qanda.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public String getRoom(Model model) {
        Room room = roomService.createRoom();

        model.addAttribute("roomName", room.getName());
        model.addAttribute("questions", roomService.getQuestionsForRoom(room.getName()));
        return "redirect:/room/" + room.getName();
    }

    @GetMapping("/{roomName}")
    public String getRoom(@PathVariable String roomName, Model model) {
        model.addAttribute("roomName", roomName);
        model.addAttribute("questions", roomService.getQuestionsForRoom(roomName));
        return "room";
    }

    @PostMapping("/{roomName}/question")
    public String postQuestion(@PathVariable String roomName, @RequestParam String questionText, Model model) {
        Room room = roomService.getRoom(roomName);
        Question question = questionService.createQuestion(questionText, room);

        room.addQuestion(question);
        roomService.save(room);

        model.addAttribute("roomName", roomName);
        model.addAttribute("questions", roomService.getQuestionsForRoom(roomName));
        return "redirect:/room/" + roomName;
    }
}
