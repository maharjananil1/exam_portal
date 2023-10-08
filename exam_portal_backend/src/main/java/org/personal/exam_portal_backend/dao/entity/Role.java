package org.personal.exam_portal_backend.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Set;

/**
    created by: maharjananil
    created on: 10/08/2023
*/
@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roleName ;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<User> users;
}
