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
    ToDoService todolists;


    @RequestMapping("/")
    public String todoLists(Model model) {
        model.addAttribute("todos", todolists.loader());
        return "list";
    }

    @GetMapping("/add")
    public String loadToDoForm(Model model) {
        model.addAttribute("todo", new ToDo());
        return "todoform";
    }

    @PostMapping("/process")
    public String loadFromToDoPage(@Valid ToDo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todoform";
        }
        int idx = todolists.getsize() + 1;
        todo.setId(idx);
        todolists.addRecord(todo);
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public String updateToDo(@PathVariable("id") int id, Model model) {
        model.addAttribute("todo", todolists.findById(id));

        return "todoform_for_update";
    }

    //replace what is updated
    @PostMapping("/update_process/{id}")
    public String loadUodatedPage(@PathVariable("id") int id, @Valid ToDo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todoform";
        }
        todo.setId(id);
        todolists.replaceRecord(todo);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteToDo(@PathVariable("id") int id) {
        todolists.deleteById(id);
        return "redirect:/";
    }
}
