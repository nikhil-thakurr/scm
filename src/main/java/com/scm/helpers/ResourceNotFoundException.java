package com.scm.helpers;

public class ResourceNotFoundException extends RuntimeException {
    

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(){
        super("Resouce Not Found");
    }

}
