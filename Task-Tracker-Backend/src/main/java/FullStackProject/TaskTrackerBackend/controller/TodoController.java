package FullStackProject.TaskTrackerBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FullStackProject.TaskTrackerBackend.dto.TodoDto;
import FullStackProject.TaskTrackerBackend.service.TodoService;
import lombok.AllArgsConstructor;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {
    @Autowired
    private TodoService todoService;

//    @PreAuthorize("hasRole('ROLE_ADMIN','ROLE_USER')")
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
       TodoDto savedTodo = todoService.addTodo(todoDto);
       return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId) {
       TodoDto todoDto = todoService.getTodo(todoId);
       return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {
       List<TodoDto> todoDtoList = todoService.getAllTodos();
       return new ResponseEntity<>(todoDtoList, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN','ROLE_USER')")
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto,
                                              @PathVariable("id") Long todoId) {
       TodoDto updatedTodo = todoService.updateTodo(todoDto, todoId);
       return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN','ROLE_USER')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId) {
        todoService.deleteTodo(todoId);
        return new ResponseEntity<>("Todo deleted successfully", HttpStatus.OK);
    }

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId) {
       TodoDto todoDto = todoService.completeTodo(todoId);
       return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PatchMapping("{id}/incomplete")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long todoId){
       TodoDto todoDto = todoService.inCompleteTodo(todoId);
       return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }
    
}
