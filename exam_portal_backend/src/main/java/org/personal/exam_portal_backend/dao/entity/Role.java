package org.personal.exam_portal_backend.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/** created by: maharjananil created on: 10/08/2023 */
@Data
@Entity
@Table(name = "roles")
public class Role {
  @Id private Long id;

  private String roleName;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
  private Set<UserRole> userRoles = new HashSet<>();
}
