package com.estudo.publication.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.estudo.publication.domain.ErrorResponse;
import com.estudo.publication.lang.EntityNotFoundException;
import com.estudo.publication.lang.FallbackException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerMethodException(Exception exception,
            HttpServletRequest httpServletRequest) {
        ErrorResponse error = ErrorResponse.builder()
            .timestamp(System.currentTimeMillis())
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .message(exception.getMessage())
            .path(httpServletRequest.getRequestURI())
            .build();
        log.error("[ERROR] payload = {}", error, exception);
        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerMethodEntityNotFoundException(Exception exception,
            HttpServletRequest httpServletRequest) {
        ErrorResponse error = ErrorResponse.builder()
            .timestamp(System.currentTimeMillis())
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .message("Registro não encontrado.")
            .path(httpServletRequest.getRequestURI())
            .build();
        log.error("[ERROR] Não foi possível encontrar a entidade = {}", httpServletRequest.getRequestURI());
        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler(FallbackException.class)
    public ResponseEntity<ErrorResponse> handlerFallbackException(Exception exception,
            HttpServletRequest httpServletRequest) {
        ErrorResponse error = ErrorResponse.builder()
            .timestamp(System.currentTimeMillis())
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .message(exception.getMessage())
            .path(httpServletRequest.getRequestURI())
            .build();
        log.error(exception.getCause().getMessage());
        return ResponseEntity.internalServerError().body(error);
    }

}
