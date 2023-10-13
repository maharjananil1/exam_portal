package org.personal.exam_portal_backend.service.user;

import lombok.RequiredArgsConstructor;
import org.personal.exam_portal_backend.dao.entity.User;
import org.personal.exam_portal_backend.dao.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/** created by: maharjananil created on: 10/12/2023 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepo userRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return this.userRepo
        .findByUsernameAndDeletedIsFalse(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }
}
