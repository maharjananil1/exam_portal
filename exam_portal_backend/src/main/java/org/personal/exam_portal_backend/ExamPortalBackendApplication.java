package org.personal.exam_portal_backend;

import org.personal.exam_portal_backend.dao.entity.Role;
import org.personal.exam_portal_backend.dao.entity.User;
import org.personal.exam_portal_backend.dao.entity.UserRole;
import org.personal.exam_portal_backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamPortalBackendApplication {
@Autowired private UserService userService;
  public static void main(String[] args) {
    SpringApplication.run(ExamPortalBackendApplication.class, args);
  }
}
