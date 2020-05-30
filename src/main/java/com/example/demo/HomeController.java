package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    ToDoService toDoService;


    @RequestMapping("/")
    public String todoLists(Model model) {
        model.addAttribute("todos", toDoService.loader());
        return "list";
    }

    @GetMapping("/add")
    public String loadToDoForm(Model model) {
        model.addAttribute("toDo", new ToDo());
        return "todoform";
    }

    @PostMapping("/process")
    public String loadFromToDoPage(@Valid ToDo toDo, BindingResult result) {
        if (result.hasErrors()) {
            return "todoform";
        }
//        int idx = toDoService.getsize() + 1;
        toDo.setId(toDoService.generateTaskId());
        toDoService.addRecord(toDo);
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public String updateToDo(@PathVariable("id") int id, Model model) {
        model.addAttribute("todo", toDoService.findById(id));

        return "todoform_for_update";
    }

    //replace what is updated
    @PostMapping("/update_process/{id}")
    public String loadUodatedPage(@PathVariable("id") int id, @Valid ToDo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todoform";
        }
        todo.setId(id);
        toDoService.replaceRecord(todo);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteToDo(@PathVariable("id") int id) {
        toDoService.deleteById(id);
        return "redirect:/";
    }
}
