package com.foro.foro_alura.Controler;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.foro.foro_alura.Controler.topico.Curso;
import com.foro.foro_alura.Controler.topico.Topico;

import java.time.LocalDateTime;


public record DatosListadoTopicos(
        Long id,
        String nombre,
        String titulo,
        String mensaje,
        String status,
        Curso curso,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime createdAt
) {
    public DatosListadoTopicos(Topico topico) {
        this(topico.getId(),
                topico.getNombre(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getStatus(),
                topico.getCurso(),
                topico.getCreatedAt());
    }


}