package org.personal.exam_portal_backend.service.user;

import org.personal.exam_portal_backend.dao.entity.Role;
import org.personal.exam_portal_backend.dao.entity.User;

import java.util.Set;

/**
    created by: maharjananil
    created on: 10/08/2023
*/public interface UserService {
    User createUser(User user) throws Exception;
}
