package com.example;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
        
class Cidade {

    private Long id;
    private String nome;
    private Estado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade(Long id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public Cidade() {
    }

}

@Data
@AllArgsConstructor
class Estado {

    private Long id;
    private String nome;

    public Estado(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Estado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

public class Function {

    @FunctionName("create-cidade")
    public Cidade createCidade(@HttpTrigger(name = "createCidade", methods = {HttpMethod.POST}, route = "cidade") Cidade cidade) {

        cidade.setId(100L);

        return cidade;
    }

    @FunctionName("read-cidade")
    public List<Cidade> readCidade(@HttpTrigger(name = "readCidade", methods = (HttpMethod.GET), route = "cidade") String cidade) {

        return Stream.of(
            new Cidade(1L, "Marilia", new Estado(1L, "Sao Paulo")),
            new Cidade(2L, "Cornelio", new Estado(2L, "Parana"))
        ).collect(Collectors.toList());

    }

        @FunctionName("edit-cidade")
            public Cidade editCidade(@HttpTrigger(name = "editCidade", methods = {HttpMethod.PUT}, route = "cidade") Cidade cidade){
                
                return cidade;
            }


        @FunctionName("delete-cidade")

            public int deleteCidade(@HttpTrigger(name = "deleteCidade", methods = { HttpMethod.DELETE}, route = "cidade/{id}") Long id){

                return 200;
            }
}