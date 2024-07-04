package com.dms.dmsback.member.controller;


import com.dms.dmsback.member.dto.UserDto;
import com.dms.dmsback.member.entity.pk.Message;
import com.dms.dmsback.member.repository.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Message> login(HttpServletRequest request, @RequestBody UserDto userDto) {
        log.debug("Accessed IP : {}", request.getRemoteAddr());
        log.debug("id : {}", userDto.getId());

        ResponseEntity<Message> response = userService.login(userDto);

        log.debug("Data : {}", response.getBody());

        return response;
    }

    @PostMapping("/register")
    public ResponseEntity<Message> register(HttpServletRequest request, @RequestBody UserDto userDto) {
        log.debug("Accessed IP : {}", request.getRemoteAddr());
        log.debug("id : {}, birth : {}, name : {}, gender : {}, address : {}", userDto.getId(), userDto.getBirth(), userDto.getName(), userDto.getGender(), userDto.getAddress());

        ResponseEntity<Message> response = userService.register(userDto);

        log.debug("Data : {}", response.getBody());

        return response;
    }

    @GetMapping("/register/validation")
    public ResponseEntity<Message> idValidation(HttpServletRequest request, @RequestParam String id) {
        log.debug("Accessed IP : {}", request.getRemoteAddr());
        log.debug("id : {}", id);

        ResponseEntity<Message> response = userService.idValidation(id);

        log.debug("Data : {}", response.getBody());

        return response;
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<Message> changeInfo(HttpServletRequest request, @PathVariable String id, @RequestBody UserDto userDto) {
        log.debug("Accessed IP : {}", request.getRemoteAddr());
        log.debug("id : {}, name : {}, birth : {}, gender : {}, address : {}", id, userDto.getName(), userDto.getBirth(), userDto.getGender(), userDto.getAddress());

        ResponseEntity<Message> response = userService.changeInfo(id, userDto);

        log.debug("Data : {}", response.getBody());

        return response;
    }

    @GetMapping("/information")
    public ResponseEntity<Message> information(HttpServletRequest request, @RequestParam String id) {
        log.debug("Accessed IP : {}", request.getRemoteAddr());
        log.debug("id : {}", id);

        ResponseEntity<Message> response = userService.information(id);

        log.debug("Data : {}", response.getBody());

        return response;
    }

}
