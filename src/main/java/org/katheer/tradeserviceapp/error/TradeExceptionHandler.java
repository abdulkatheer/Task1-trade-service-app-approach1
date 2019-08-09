package org.katheer.tradeserviceapp.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class TradeExceptionHandler {

   @ExceptionHandler(value = {ConstraintViolationException.class})
   public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest webRequest) {
      Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

      Set<String> messages = new HashSet<>(constraintViolations.size());

      messages.addAll(constraintViolations.stream()
            .map(constraintViolation -> String.format("%s value '%s' %s", constraintViolation.getPropertyPath(),
                  constraintViolation.getInvalidValue(), constraintViolation.getMessage()))
            .collect(Collectors.toList()));

      return new ResponseEntity<>(messages, new HttpHeaders(), HttpStatus.BAD_REQUEST);
   }

}