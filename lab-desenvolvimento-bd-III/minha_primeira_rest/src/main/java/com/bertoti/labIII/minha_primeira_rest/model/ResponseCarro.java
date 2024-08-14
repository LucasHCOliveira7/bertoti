package com.bertoti.labIII.minha_primeira_rest.model;

import org.springframework.http.HttpStatus;

public class ResponseCarro {
    private Carro carro;
    private HttpStatus status;
    private String mensagem;

    public ResponseCarro(Carro carro, HttpStatus status, String mensagem) {
        this.carro = carro;
        this.status = status;
        this.mensagem = mensagem;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
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

