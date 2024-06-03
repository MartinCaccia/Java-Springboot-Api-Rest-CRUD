package com.example.demo.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
//    private String id;
//    private String name;
//    private String userName;
//    private String email;
//    private String avatar;
//    private String createdAt;

    String id;
    String name;
    String userName;
    String email;
    String avatar;
    String createdAt;
}
