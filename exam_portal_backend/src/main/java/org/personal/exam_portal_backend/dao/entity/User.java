package org.personal.exam_portal_backend.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

/** created by: maharjananil created on: 10/08/2023 */
@Data
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(unique = true)
  private String username;
  private String password;
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

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
  private Set<UserRole> userRoles = new HashSet<>();
}
