package com.example.bartender105.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/h")
public class UserController {
    //    private final UserRepository userRepository;
//
//    @GetMapping(value = "users")
//    public @ResponseBody List<User> getAll() {
//        return this.userRepository.getAll();
//    }
    @GetMapping("/hi2")
    public String hi(){
        return "hi, alcoholic";
    }
}
