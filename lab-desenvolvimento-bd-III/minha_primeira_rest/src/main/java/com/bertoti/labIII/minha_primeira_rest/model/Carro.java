package com.bertoti.labIII.minha_primeira_rest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Carro {
    private Integer id;
    private String marca;
    private String modelo;

    @JsonCreator
    public Carro(@JsonProperty("id") Integer id,
                 @JsonProperty("marca") String marca,
                 @JsonProperty("modelo") String modelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
