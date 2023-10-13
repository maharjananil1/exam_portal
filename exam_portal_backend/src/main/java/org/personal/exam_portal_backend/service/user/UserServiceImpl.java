package org.personal.exam_portal_backend.service.user;

import java.util.Optional;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.personal.exam_portal_backend.common.configuration.JwtService;
import org.personal.exam_portal_backend.common.domain.JWTResponse;
import org.personal.exam_portal_backend.common.domain.LoginRequest;
import org.personal.exam_portal_backend.common.exceptionhandler.exception.AlreadyExistsException;
import org.personal.exam_portal_backend.common.exceptionhandler.exception.NotFoundException;
import org.personal.exam_portal_backend.dao.entity.User;
import org.personal.exam_portal_backend.dao.entity.UserRole;
import org.personal.exam_portal_backend.dao.repo.RoleRepo;
import org.personal.exam_portal_backend.dao.repo.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/** created by: maharjananil created on: 10/08/2023 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final UserRepo userRepo;
  private final RoleRepo roleRepo;

  @Override
  public User createUser(User user, Set<UserRole> userRoles) {
    Optional<User> userOptional = this.userRepo.findByUsernameAndDeletedIsFalse(user.getUsername());
    if (userOptional.isPresent()) throw new AlreadyExistsException("User already present");
    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
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

  @Override
  public JWTResponse login(LoginRequest loginRequest) {
    this.authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            loginRequest.getUsername(), loginRequest.getPassword()));
    User userDetails =
        this.userRepo
            .findByUsernameAndDeletedIsFalse(loginRequest.getUsername())
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    String token = this.jwtService.generateToken(userDetails);
    return JWTResponse.builder().token(token).build();
  }
}
