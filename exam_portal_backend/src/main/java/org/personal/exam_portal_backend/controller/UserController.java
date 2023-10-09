package org.personal.exam_portal_backend.controller;

import lombok.AllArgsConstructor;
import org.personal.exam_portal_backend.dao.entity.Role;
import org.personal.exam_portal_backend.dao.entity.User;
import org.personal.exam_portal_backend.dao.entity.UserRole;
import org.personal.exam_portal_backend.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/** created by: maharjananil created on: 10/08/2023 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping
  public ResponseEntity<?> addUser(@RequestBody User user) {
    Set<UserRole> userRoleSet = new HashSet<>();
    Role role = new Role();
    role.setId(45L);
    role.setRoleName("NORMAL");
    UserRole userRole = new UserRole();
    userRole.setRole(role);
    userRole.setUser(user);
    userRoleSet.add(userRole);
    return new ResponseEntity<>(this.userService.createUser(user, userRoleSet), HttpStatus.CREATED);
  }

  @GetMapping("/{username}")
  public ResponseEntity<?> getUser(@PathVariable("username") String username){
    return new ResponseEntity<>(this.userService.getUserByUsername(username),HttpStatus.OK);
  }

  @DeleteMapping("/{username}")
  public ResponseEntity<?> deleteUser(@PathVariable("username") String username){
    return new ResponseEntity<>(this.userService.deleteUserByUsername(username),HttpStatus.OK);
  }
}
