/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viaja.colombia.model;

import java.util.Date;

/**
 *
 * @author GuerreroGomez
 */
public class SystemMessage {
    
    private String message;
    private String description;
    private Date timestamp;
    private int code;
    
    public SystemMessage() {
    }

    public SystemMessage(String message, String description, Date timestamp, int code) {
        this.message = message;
        this.description = description;
        this.timestamp = timestamp;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    
}
