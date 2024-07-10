package com.example.CineAll.Services;

import com.example.CineAll.Models.Usuario;
import com.example.CineAll.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(username);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_" + usuario.getClass().getSimpleName().toUpperCase());

            return new User(username, usuario.getSenha(), authorities);
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
    }
}
