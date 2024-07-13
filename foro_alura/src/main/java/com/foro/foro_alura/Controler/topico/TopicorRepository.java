package com.foro.foro_alura.Controler.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TopicorRepository extends JpaRepository<Topico,Long> {


    Page<Topico> findAByActivoTrue(Pageable paginacion);
}
