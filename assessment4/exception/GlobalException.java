package com.tcs.assessment4.exception;

import java.util.HashMap;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Map<String, String>> handleNpe(NullPointerException ne){
        Map<String, String> hm = new HashMap<>();
        hm.put("errorCode", "101");
        hm.put("errorMessage", "There is some null pointer Exception");
        hm.put("details", ne == null ? "" : ne.getMessage());
        return new ResponseEntity<>(hm, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(exception=MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleBeanError(MethodArgumentNotValidException me){
		Map<String, String> hm = new HashMap<>();
		BindingResult br = me.getBindingResult();
		br.getFieldErrors().stream().forEach(x -> hm.put(x.getField(), x.getDefaultMessage()));
		return new ResponseEntity<>(hm, HttpStatus.OK);
	}
    
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleAnfe(AccountNotFoundException ne){
        Map<String, String> hm = new HashMap<>();
        hm.put("errorCode", "102");
        hm.put("errorMessage", "There is some Account Not Found Exception");
        hm.put("details", ne == null ? "" : ne.getMessage());
        return new ResponseEntity<>(hm, HttpStatus.INTERNAL_SERVER_ERROR);
    }
   
}