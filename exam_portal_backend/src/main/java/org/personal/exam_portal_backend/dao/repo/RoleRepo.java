package org.personal.exam_portal_backend.dao.repo;

import org.personal.exam_portal_backend.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
    created by: maharjananil
    created on: 10/08/2023
*/
@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
}
