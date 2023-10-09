package org.personal.exam_portal_backend.common.domain;

import lombok.Data;
import org.springframework.http.HttpStatus;

/** created by: maharjananil created on: 10/09/2023 */
@Data
public class BaseResponse {
    private String message;
    private HttpStatus status;
}
