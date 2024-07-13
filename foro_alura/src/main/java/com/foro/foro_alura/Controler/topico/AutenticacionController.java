package com.foro.foro_alura.Controler.topico;

import com.foro.foro_alura.ususarios.TokenService;
import com.foro.foro_alura.ususarios.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsiario datosAutenticacionUsiario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                datosAutenticacionUsiario.login(),  // Acceso directo al campo 'login'
                datosAutenticacionUsiario.clave()); // Acceso directo al campo 'clave'

        var ususarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken  = tokenService.generarToken((Usuario) ususarioAutenticado.getPrincipal());
        // Aquí podrías manejar la lógica adicional después de la autenticación

        return ResponseEntity.ok(new DatosJWTtoken(JWTtoken));
    }
}
