package com.example.demo;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//import static com.example.demo.ToDoListApplication.id_for_task;

@Service
public class ToDoService {
    public static int id_for_task;


    ArrayList<ToDo> todolist = new ArrayList<>();

    public void addRecord(ToDo todo) {
        todolist.add(0, todo);
    }

    public int getsize() {
        return todolist.size();
    }

    public ToDo findById(int id) {
        ToDo result = null;
        for (int i = 0; i < todolist.size(); i++) {
            if (todolist.get(i).getId() == id) {
                result = todolist.get(i);
            }
        }
        return result;
    }

    public void replaceRecord(ToDo todo) {
        int index = todo.getId();
        for (int i = 0; i < todolist.size(); i++) {

            if (todolist.get(i).getId() == index) {
                todolist.remove(i);
                todolist.add(i, todo);
            }
        }
    }

    public void deleteById(int id) {
        for (int i = 0; i < todolist.size(); i++) {
            if (todolist.get(i).getId() == id) {
                todolist.remove(i);
            }
        }
    }
    public ArrayList<ToDo> loader() {
        return todolist;
    }
    public int generateTaskId() {
//        int id = toDo.varValueForTaskId();
        id_for_task += 1;
        return id_for_task;
    }

}
