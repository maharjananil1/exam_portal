package org.personal.exam_portal_backend.common.exceptionhandler.exception;

/** created by: maharjananil created on: 10/09/2023 */
public class AlreadyExistsException extends RuntimeException {
  public AlreadyExistsException(String message) {
    super(message);
  }
}
