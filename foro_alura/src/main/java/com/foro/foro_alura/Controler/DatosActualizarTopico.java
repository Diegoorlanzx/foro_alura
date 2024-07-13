package com.foro.foro_alura.Controler;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id, String nombre, String telefono , String titulo, String mensaje) {

}
