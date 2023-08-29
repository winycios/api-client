package com.myapi.demo.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

/* classe criada para a criação e chamada de usuario */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    /* Utilização do notEmpty caso o campo vier vazio e do Lenght para determinar um tamanho de caracteres */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo NOME é obrigatório")
    @Length(min = 3, max = 100, message = "O nome deve ter entre 3 a 100 caracteres")
    private String nome;

    @NotEmpty(message = "Campo LOGIN é obrigatório")
    @Length(min = 3, max = 50, message = "O LOGIN deve ter entre 3 a 50 caracteres")
    private String login;

    @NotEmpty(message = "Campo SENHA é obrigatório")
    @Length(min = 3, max = 10, message = "A senha deve ter entre 3 a 10 caracteres")
    private String senha;

    public Usuario() {
        super();
    }

    public Usuario(Integer id, String nome, String login, String senha) {
        super();

        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {

        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {

        this.senha = senha;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
