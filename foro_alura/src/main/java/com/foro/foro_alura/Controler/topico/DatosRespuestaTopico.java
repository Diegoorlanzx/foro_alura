package com.foro.foro_alura.Controler.topico;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(Long id,
                                   String nombre,
                                   String titulo,
                                   String mensaje,
                                   String status,
                                   Curso curso,
                                   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
                                   LocalDateTime createdAt) {
}
