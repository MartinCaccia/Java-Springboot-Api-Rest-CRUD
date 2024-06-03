package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
/* import org.springframework.beans.factory.annotation.Autowired; */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

//@Tag(name = "Users", description = "CRUD of users from mockapi.io")
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

/*
    @GetMapping("/users")
    public Map<String, String> user(){
        Map<String, String> json = new HashMap<>();
        json.put("message", "Hola mundo spring boot api rest");
        json.put("date", new Date().toString());
        return json;
    }
    public UserController(UserService userService) {
        this.userService = userService;
    }
*/


    //@Autowired
    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDTO user){
        userService.createUser(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable("id") Integer id, @RequestBody UserDTO user){
        userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
    }
}
