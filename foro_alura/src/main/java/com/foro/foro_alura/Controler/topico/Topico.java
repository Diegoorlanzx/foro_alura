package com.foro.foro_alura.Controler.topico;

import com.foro.foro_alura.Controler.DatosActualizarTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topico")
@Entity(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String telefono;

    private String documento;
    private String titulo;

    private String mensaje;

    private String status;
    private boolean activo;


    @Enumerated(EnumType.STRING)
    private  Curso curso;

    private LocalDateTime createdAt;


    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.activo= true;
        this.nombre= datosRegistroTopico.nombre();
        this.email= datosRegistroTopico.email();
        this.telefono= datosRegistroTopico.telefono();
        this.documento= datosRegistroTopico.documento();
        this.titulo= datosRegistroTopico.titulo();
        this.mensaje= datosRegistroTopico.mensaje();
        this.status= datosRegistroTopico.status();

        this.curso= datosRegistroTopico.curso();
        this.createdAt = LocalDateTime.now(); // Asignación de la fecha y hora actual
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.nombre() != null) {
            this.nombre = datosActualizarTopico.nombre();
        }
        if (datosActualizarTopico.telefono() != null) {
            this.telefono = datosActualizarTopico.telefono();
        }
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }

    }

    public void desactivarTopico() {
        this.activo=false;
    }
}
