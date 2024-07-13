package com.foro.foro_alura.ususarios;

import com.foro.foro_alura.ususarios.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.replace("Bearer ", "");
            System.out.println(token);

            try {
                String subject = tokenService.getSubject(token);
                System.out.println(subject);
                var usuario = usuarioRepository.findByLogin(subject);
                var authentication= new UsernamePasswordAuthenticationToken(usuario, null,usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                // Aquí puedes establecer el usuario autenticado en el contexto de seguridad si es necesario
            } catch (RuntimeException e) {
                System.out.println("Token inválido: " + e.getMessage());
                // Opcional: devolver un error de autenticación
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido");
                return;
            }
        } else {
            System.out.println("Authorization header is missing or does not start with Bearer");
        }

        filterChain.doFilter(request, response);
    }
}
