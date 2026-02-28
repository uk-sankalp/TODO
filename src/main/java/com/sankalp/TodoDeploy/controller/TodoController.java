package com.sankalp.TodoDeploy.controller;

import com.sankalp.TodoDeploy.dto.ResponseDTO;
import com.sankalp.TodoDeploy.dto.TodoDTO;
import com.sankalp.TodoDeploy.entity.Todo;
import com.sankalp.TodoDeploy.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/show")
    public List<ResponseDTO> showAll(){
    return todoService.showAll();
    }
    @PostMapping("/create")
    public Todo createTodo(@RequestBody TodoDTO request){
        return todoService.createTask(request);
    }
    @PatchMapping("/update/{id}")
    public Todo updateTask(@PathVariable Long id,@RequestBody TodoDTO request){
        return todoService.updateTask(id,request);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        return todoService.deleteTodo(id);
    }
}
