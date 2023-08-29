package com.myapi.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapi.demo.domain.Usuario;
import com.myapi.demo.repositories.UsuarioRepository;
import com.myapi.demo.service.exceptions.ObjectNotFound;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    /* Procura pelo id do usuario */
    public Usuario findById(Integer id) {
        Optional<Usuario> obj = repository.findById(id);

        /* caso ele não encontre retornará o id e o erro */
        return obj.orElseThrow(
                () -> new ObjectNotFound("Objeto Não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
    }

    /* retorna todos os usuarios */
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    /*
     * Procura pelo ID do usuario, caso encontrado irá fazer update de suas
     * informações
     */
    public Usuario update(Integer id, Usuario obj) {
        Usuario newUser = findById(id);
        newUser.setNome(obj.getNome());
        newUser.setLogin(obj.getLogin());
        newUser.setSenha(obj.getSenha());

        return repository.save(newUser);
    }

    /* Metodo para criação de um usuario */
    public Usuario create(Usuario obj) {
        /*o ID é nulo por medida de segurança onde sempre que for chamado o metodo POST, necessariamente 
         * criará um novo usuario. E não atualizará algum ja existente
         */
        obj.setId(null);
        return repository.save(obj);
    }

    /* Procurar id e deleta-lo */
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
