// package br.com.projeto.teste.config;

// import java.util.List;

// import javax.management.relation.Role;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Profile;
// import org.springframework.scheduling.config.Task;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import br.com.projeto.teste.model.Usuario;
// import br.com.projeto.teste.repository.MovimentacaoRepository;
// import br.com.projeto.teste.repository.ProdutoRepository;
// import br.com.projeto.teste.repository.UsuarioRepositorio;



// @Configuration
// @Profile("Gerente")
// public class DatabaseSeed implements CommandLineRunner {

//     @Autowired
//     MovimentacaoRepository movimentacaoRepository;

//     @Autowired
//     ProdutoRepository produtoRepository;

//     @Autowired
//     PasswordEncoder passwordEncoder;

//     @Autowired
//     UsuarioRepositorio usuarioRepositorio;

//     @Override
//     public void run(String... args) throws Exception {

//         usuarioRepositorio.save(
//             new Usuario()
//                 .name("João")
//                 .email("gusta@fiap.com.br")
//                 .password(passwordEncoder.encode("123"))
//                 .withRole(new Role("ROLE_USER", null))
//         );

//         usuarioRepositorio.save(
//             new Usuario()
//                 .name("Maria")
//                 .email("maria@fiap.com.br")
//                 .password(passwordEncoder.encode("123")) 
//                 .withRole(new Role("ROLE_ADMIN", null))
//         );
//     }
    
// }