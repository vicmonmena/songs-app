package com.vicmonmena.songserver.lab.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Clase que contrala las excepciones producidas por peticiones al servidor.
 * 
 * @author Vicente Montaño Mena
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Resource identifier.
     */
    private Long resourceId;

    /**
     * Constructor parametrizer.
     * @param resourceId
     */
    public ResourceNotFoundException(Long resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * Get tht resource identifier.
     * @return the resource identifier.
     */
    public Long getResourceId() {
        return resourceId;
    }
}