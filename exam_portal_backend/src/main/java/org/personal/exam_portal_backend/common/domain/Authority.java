package org.personal.exam_portal_backend.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/** created by: maharjananil created on: 10/12/2023 */
@Data
@AllArgsConstructor
public class Authority implements GrantedAuthority {
  private String authority;
}
