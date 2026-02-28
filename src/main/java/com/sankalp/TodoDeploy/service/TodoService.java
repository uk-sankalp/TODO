package com.sankalp.TodoDeploy.service;

import com.sankalp.TodoDeploy.dto.ResponseDTO;
import com.sankalp.TodoDeploy.dto.TodoDTO;
import com.sankalp.TodoDeploy.entity.Todo;
import com.sankalp.TodoDeploy.repo.TodoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepo repo;
    public Todo createTask(TodoDTO request){
        Todo data=new Todo();
        data.setTitle(request.getTitle());
        data.setCompleted(false);
        data.setCreatedAt(LocalDateTime.now());
        data.setUpdatedAt(LocalDateTime.now());
        return repo.save(data);
    }
    public List<ResponseDTO> showAll(){
        List<Todo> todos=repo.findAll();
        return todos.stream()
                .map(todo ->{
                    ResponseDTO dto=new ResponseDTO();
                    dto.setId(todo.getId());
                    dto.setTitle(todo.getTitle());
                    dto.setCompleted(todo.isCompleted());
                    dto.setCreatedAt(todo.getCreatedAt());
                    dto.setUpdatedAt(todo.getUpdatedAt());
                    return dto;
                })
                .toList();
    }
    public Todo updateTask(Long id,TodoDTO request){
        Todo data=repo.findById(id).orElseThrow(()->new RuntimeException("No Task Found"));
        if(request.getTitle()!=null){
            data.setTitle(request.getTitle());
        }
        if(request.getCompleted()!=null){
            data.setCompleted(request.getCompleted());
        }
        data.setUpdatedAt(LocalDateTime.now());
        return repo.save(data);
    }
    public String deleteTodo(Long id){
        repo.deleteById(id);
        return "Deleted";
    }
}
