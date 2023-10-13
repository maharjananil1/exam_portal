package org.personal.exam_portal_backend.controller;

import lombok.AllArgsConstructor;
import org.personal.exam_portal_backend.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** created by: maharjananil created on: 10/12/2023 */
@RestController
@RequestMapping("user")
@AllArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserService userService;
    @GetMapping("{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username){
        return new ResponseEntity<>(this.userService.getUserByUsername(username), HttpStatus.OK);
    }

    @DeleteMapping("{username}")
    public ResponseEntity<?> deleteUser(@PathVariable("username") String username){
        return new ResponseEntity<>(this.userService.deleteUserByUsername(username),HttpStatus.OK);
    }
}
