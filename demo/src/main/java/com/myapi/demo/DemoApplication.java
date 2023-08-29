package com.myapi.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myapi.demo.domain.Usuario;
import com.myapi.demo.repositories.UsuarioRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired(required=true)
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		/* Cadastro dos usuarios */
		Usuario user = new Usuario(null, "Winyc", "wiwi", "123");
		Usuario user2 = new Usuario(null, "Leticia", "lele", "123");

		/* Salvar os usuarios no banco de dados o h2 */
		usuarioRepository.saveAll(Arrays.asList(user, user2));
	}

}
