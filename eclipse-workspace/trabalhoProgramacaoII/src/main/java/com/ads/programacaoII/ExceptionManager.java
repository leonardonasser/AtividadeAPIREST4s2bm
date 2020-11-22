package com.ads.programacaoII;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ads.programacaoII.veiculo.RegistroDuplicadoException;


@ControllerAdvice
public class ExceptionManager {
	
    @ExceptionHandler(RegistroDuplicadoException.class)
    public ResponseEntity<Void> handleConflict() {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

}
