package com.pichincha.bank_customer_ms.shared.infrastructure.config;

import com.pichincha.bank_customer_ms.shared.application.exceptions.EntityNotFoundRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail generalError(RuntimeException ex, WebRequest request){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail methodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request){
        var detail = Objects.requireNonNull(ex.getDetailMessageArguments());
        var detailAsString = Arrays.stream(detail).map(String::valueOf).collect(Collectors.joining());
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, detailAsString);
    }

    @ExceptionHandler(EntityNotFoundRuntimeException.class)
    public ProblemDetail entityNotFoundRuntimeException(EntityNotFoundRuntimeException ex, WebRequest request){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    }


}
