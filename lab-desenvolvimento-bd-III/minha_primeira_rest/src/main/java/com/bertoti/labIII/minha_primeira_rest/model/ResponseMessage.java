package com.bertoti.labIII.minha_primeira_rest.model;

import org.springframework.http.HttpStatus;

public class ResponseMessage {
    private HttpStatus status;
    private String mensagem;

    public ResponseMessage(HttpStatus status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}

