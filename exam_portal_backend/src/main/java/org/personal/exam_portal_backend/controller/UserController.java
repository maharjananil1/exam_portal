package org.personal.exam_portal_backend.controller;

import lombok.AllArgsConstructor;
import org.personal.exam_portal_backend.dao.entity.User;
import org.personal.exam_portal_backend.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** created by: maharjananil created on: 10/08/2023 */
@RestController
@RequestMapping(value = "user")
@AllArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping
  public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
    return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.CREATED);
  }
}
