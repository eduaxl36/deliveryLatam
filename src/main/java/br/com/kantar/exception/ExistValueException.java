/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author eduardo
 */

@ResponseStatus(code = HttpStatus.CONFLICT)         
public class ExistValueException extends RuntimeException {

    public ExistValueException(String mensagem) {
    
    super(mensagem);
        
        
    }
    
    
}
