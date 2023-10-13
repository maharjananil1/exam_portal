package org.personal.exam_portal_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ExamPortalBackendApplication {
  public static void main(String[] args) {
    SpringApplication.run(ExamPortalBackendApplication.class, args);
  }
}
