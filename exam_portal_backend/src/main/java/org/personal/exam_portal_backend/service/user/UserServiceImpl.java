package org.personal.exam_portal_backend.service.user;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.personal.exam_portal_backend.dao.entity.User;
import org.personal.exam_portal_backend.dao.repo.RoleRepo;
import org.personal.exam_portal_backend.dao.repo.UserRepo;
import org.springframework.stereotype.Service;

/** created by: maharjananil created on: 10/08/2023 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepo userRepo;
  private final RoleRepo roleRepo;

  @Override
  public User createUser(User user) throws Exception {
    Optional<User> userOptional = this.userRepo.findByUsername(user.getUsername());
    if (userOptional.isPresent()) {
      System.out.println("User is already present");
      throw new Exception("User already present");
    }
    User newUser = this.userRepo.save(user);
    return newUser;
  }
}
