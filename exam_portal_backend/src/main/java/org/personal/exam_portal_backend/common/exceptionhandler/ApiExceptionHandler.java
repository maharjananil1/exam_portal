package org.personal.exam_portal_backend.common.exceptionhandler;

import org.personal.exam_portal_backend.common.domain.BaseResponse;
import org.personal.exam_portal_backend.common.exceptionhandler.exception.AlreadyExistsException;
import org.personal.exam_portal_backend.common.exceptionhandler.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** created by: maharjananil created on: 10/09/2023 */
@ControllerAdvice
public class ApiExceptionHandler {
  @ExceptionHandler({AlreadyExistsException.class, Exception.class})
  public ResponseEntity<BaseResponse> handleException(RuntimeException ex) {
    BaseResponse response = new BaseResponse();
    response.setMessage(ex.getMessage());
    response.setStatus(HttpStatus.BAD_REQUEST);
    return new ResponseEntity<>(response, response.getStatus());
  }

  @ExceptionHandler({NotFoundException.class})
  public ResponseEntity<BaseResponse> handleNotFoundException(RuntimeException ex) {
    BaseResponse response = new BaseResponse();
    response.setMessage(ex.getMessage());
    response.setStatus(HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(response, response.getStatus());
  }
}
