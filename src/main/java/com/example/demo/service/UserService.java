package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    @Value("${spring.users.service.base-url}")
    private String baseURL;

    private final RestTemplate restTemplate;

    public List<UserDTO> getUsers(){
        UserDTO[] response = restTemplate.getForObject(baseURL + "/users", UserDTO[].class);
        log.info("getUsers()", (Object) response.toString());
        return Arrays.asList(response);
    }

    public UserDTO getUserById(Integer id){
        UserDTO response = restTemplate.getForObject(baseURL + "/users/"+id, UserDTO.class);
        log.info("getUserById()", (Object) response.toString());
        return response;
    }

    public void createUser(UserDTO user){
        log.info("createUser()", user);
        restTemplate.postForEntity(baseURL + "/users", user, UserDTO.class);
    }

    public void updateUser(Integer id, UserDTO user){
        log.info("updateUser()", "id: ${id} user: ${user}");
        restTemplate.put(baseURL + "/users/"+id, user);
    }

    public void deleteUser(Integer id){
        log.info("deleteUser()", "id: ${id}");
        restTemplate.delete(baseURL + "/users/"+id);
    }
}
