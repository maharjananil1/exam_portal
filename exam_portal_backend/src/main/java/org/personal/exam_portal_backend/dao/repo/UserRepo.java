package org.personal.exam_portal_backend.dao.repo;

import org.personal.exam_portal_backend.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
    created by: maharjananil
    created on: 10/08/2023
*/
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
