//package com.aldousdev.airlines.exceptions;
//
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.ErrorResponse;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.nio.file.AccessDeniedException;
//import java.time.Instant;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    // Обработка кастомных исключений
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
//        ErrorResponse response = new ErrorResponse(
//                ex.getMessage(),
//                HttpStatus.NOT_FOUND.value(),
//                Instant.now()
//        );
//        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(ResourceConflictException.class)
//    public ResponseEntity<ErrorResponse> handleResourceConflict(ResourceConflictException ex) {
//        ErrorResponse response = new ErrorResponse(
//                ex.getMessage(),
//                HttpStatus.CONFLICT.value(),
//                Instant.now()
//        );
//        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
//    }
//
//    // Обработка ошибок валидации
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
//        List<String> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(FieldError::getDefaultMessage)
//                .collect(Collectors.toList());
//
//        ErrorResponse response = new ErrorResponse(
//                "Validation failed: " + String.join(", ", errors),
//                HttpStatus.BAD_REQUEST.value(),
//                Instant.now()
//        );
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
//
//    // Обработка ошибок безопасности
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<ErrorResponse> handleAccessDenied(AccessDeniedException ex) {
//        ErrorResponse response = new ErrorResponse(
//                "Access denied: " + ex.getMessage(),
//                HttpStatus.FORBIDDEN.value(),
//                Instant.now()
//        );
//        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
//    }
//
//    // Общая обработка всех остальных исключений
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex) {
//        ErrorResponse response = new ErrorResponse(
//                "Internal server error: " + ex.getMessage(),
//                HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                Instant.now()
//        );
//        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}

package com.aldousdev.airlines.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        // Здесь можно детально обрабатывать исключения или возвращать более структурированный ответ
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Можно добавить обработчики для других типов исключений
}
