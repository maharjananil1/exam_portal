package org.personal.exam_portal_backend.service.user;

import java.util.Optional;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.personal.exam_portal_backend.common.exceptionhandler.exception.AlreadyExistsException;
import org.personal.exam_portal_backend.common.exceptionhandler.exception.NotFoundException;
import org.personal.exam_portal_backend.dao.entity.User;
import org.personal.exam_portal_backend.dao.entity.UserRole;
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
  public User createUser(User user, Set<UserRole> userRoles) {
    Optional<User> userOptional = this.userRepo.findByUsernameAndDeletedIsFalse(user.getUsername());
    if (userOptional.isPresent()) throw new AlreadyExistsException("User already present");
    for (UserRole userRole : userRoles) {
      roleRepo.save(userRole.getRole());
    }
    user.getUserRoles().addAll(userRoles);
    return this.userRepo.save(user);
  }

  @Override
  public User getUserByUsername(String username) {
    Optional<User> userOptional = this.userRepo.findByUsernameAndDeletedIsFalse(username);
    if (userOptional.isEmpty()) throw new NotFoundException("User not found");
    return userOptional.get();
  }

  @Override
  public String deleteUserByUsername(String username) {
    Optional<User> userOptional = this.userRepo.findByUsernameAndDeletedIsFalse(username);
    if (userOptional.isEmpty()) throw new NotFoundException("User not found");
    userOptional.get().setDeleted(true);
    this.userRepo.save(userOptional.get());
    return "Success";
  }
}
