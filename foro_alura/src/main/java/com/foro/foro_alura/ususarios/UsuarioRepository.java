package com.foro.foro_alura.ususarios;


import com.foro.foro_alura.Controler.topico.Topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Page<Topico> findByActivoTrue(Pageable paginacion);

    UserDetails findByLogin(String username);
}
