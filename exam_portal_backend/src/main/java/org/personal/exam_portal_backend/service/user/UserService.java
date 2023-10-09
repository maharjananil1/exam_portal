package org.personal.exam_portal_backend.service.user;

import java.util.Set;
import org.personal.exam_portal_backend.dao.entity.User;
import org.personal.exam_portal_backend.dao.entity.UserRole;

/** created by: maharjananil created on: 10/08/2023 */
public interface UserService {
  User createUser(User user, Set<UserRole> userRoles);

  User getUserByUsername(String username);

  String deleteUserByUsername(String username);
}
