package com.myapi.demo.resources.exceptions;

/* Criação dos metodos da chamadas de erro */
public class StandardError {

    private Integer status;
    private Long hora;
    private String message;

    public StandardError() {
        super();
    }

    public StandardError(Integer status, Long hora, String message) {
        super();

        this.status = status;
        this.hora = hora;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
        this.hora = hora;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
