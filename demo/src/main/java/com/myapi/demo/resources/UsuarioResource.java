package com.myapi.demo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myapi.demo.domain.Usuario;
import com.myapi.demo.service.UsuarioService;

@RestController
/* Criação do endpoint */
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    /* Chamar o usuario pelo ID */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id) {

        Usuario obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    /* Exibir todos os usuarios */
    @GetMapping("/total")
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    /* update de dados */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario obj){
        Usuario newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    /* Criação de usuario metodo post */
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario obj){
        Usuario newObj = service.create(obj);
        /* mostra o caminho http que o endpoint criou para acessar as informações daquele usuario */
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    /* Delete de usuario */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
