package org.personal.exam_portal_backend.dao.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;


/**
    created by: maharjananil
    created on: 10/08/2023
*/
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @Column(columnDefinition = "text")
    private String about;
    @Column(name = "is_active")
    private boolean active = true;
    @Column(name = "is_deleted")
    private boolean deleted;
    private String profile;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Role> roles;
}
