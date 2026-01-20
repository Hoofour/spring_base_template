package com.ra.spring_base_template.exception;

import com.ra.spring_base_template.dto.ResponseWrapper;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.stream.Collectors;

public class GlobalExceptionHandler {
    // 1. Lỗi định dạng tham số truyền vào (ví dụ: sai định dạng ngày)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ResponseWrapper<?>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String message = "Tham số '" + ex.getName() + "' không hợp lệ. Định dạng đúng: yyyy-MM-dd";
        return buildBadRequest(message);
    }

    // 2. Lỗi validate @Valid (ví dụ: @NotBlank)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseWrapper<?>> handleValidationErrors(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return buildBadRequest(message);
    }

    // 3. Lỗi do mình tự ném ra (ví dụ: sai mật khẩu cũ)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseWrapper<?>> handleIllegalArgument(IllegalArgumentException ex) {
        return buildBadRequest(ex.getMessage());
    }

    // Optional: constraint violations (nếu dùng @Validated ở level class/controller)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseWrapper<?>> handleConstraintViolation(ConstraintViolationException ex) {
        String message = ex.getConstraintViolations().stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.joining(", "));
        return buildBadRequest(message);
    }

    // ======================
    // Utility method
    private ResponseEntity<ResponseWrapper<?>> buildBadRequest(String message) {
        return ResponseEntity.badRequest().body(
                ResponseWrapper.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .code(HttpStatus.BAD_REQUEST.value())
                        .message(message)
                        .data(null)
                        .build()
        );
    }

    // 4. RuntimeException (thường là lỗi business logic)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseWrapper<?>> handleRuntimeException(RuntimeException ex) {
        return buildBadRequest(ex.getMessage());
    }

    // 5. ResourceNotFoundException (dùng cho 404 - dữ liệu không tồn tại)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseWrapper<?>> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ResponseWrapper.builder()
                        .status(HttpStatus.NOT_FOUND)
                        .code(HttpStatus.NOT_FOUND.value())
                        .message(ex.getMessage())
                        .data(null)
                        .build()
        );
    }
}
