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
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import org.personal.exam_portal_backend.common.domain.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/** created by: maharjananil created on: 10/08/2023 */
@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {
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
  @Column(columnDefinition = "boolean default true" )
  private boolean accountNonLocked = true;
  @Column(columnDefinition = "boolean default true" )
  private boolean accountNonExpired = true;
  @Column(columnDefinition = "boolean default true" )
  private boolean credentialsNonExpired = true;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
  private Set<UserRole> userRoles = new HashSet<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Set<Authority> authoritySet = new HashSet<>();
    this.userRoles.forEach(userRole -> authoritySet.add(new Authority(userRole.getRole().getRoleName())));
    return authoritySet;
  }
  @Override
  public boolean isEnabled() {
    return active;
  }
}
