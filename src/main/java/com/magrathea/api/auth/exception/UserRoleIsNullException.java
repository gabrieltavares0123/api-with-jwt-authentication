package com.magrathea.api.auth.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UserRoleIsNullException extends RuntimeException {
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    private String errorMessage = "Role is null.";
}
