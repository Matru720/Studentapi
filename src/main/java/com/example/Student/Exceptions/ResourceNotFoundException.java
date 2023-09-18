package com.example.Student.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ResourceNotFoundException extends RuntimeException{
    String resourceName;
    String fieldName;
    long findValue;
    public ResourceNotFoundException(String resourceName,String fieldName,long findValue){
        super(String.format("%s not found with %s : %s",resourceName,fieldName,findValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.findValue = findValue;
    }
}
