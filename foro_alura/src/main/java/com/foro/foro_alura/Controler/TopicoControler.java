package com.foro.foro_alura.Controler;

import com.foro.foro_alura.Controler.topico.DatosRegistroTopico;
import com.foro.foro_alura.Controler.topico.DatosRespuestaTopico;
import com.foro.foro_alura.Controler.topico.Topico;
import com.foro.foro_alura.Controler.topico.TopicorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topico")
public class TopicoControler {
    @Autowired
    private TopicorRepository topicorRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico>  registrarTopico(@Valid @RequestBody DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder){
        Topico topico =topicorRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico= new DatosRespuestaTopico(topico.getId(),topico.getNombre(),topico.getTitulo(),topico.getMensaje(),
                topico.getStatus(),topico.getCurso(),topico.getCreatedAt());
       URI uri = uriComponentsBuilder.path("/medico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(datosRespuestaTopico);

    }
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listaTopicos(@PageableDefault(size = 12 ,sort = "nombre") Pageable paginacion) {
        Page<Topico> topicos = topicorRepository.findAByActivoTrue(paginacion);
        return ResponseEntity.ok(topicos.map(DatosListadoTopicos::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico= topicorRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(),topico.getNombre(),topico.getTitulo(),topico.getMensaje(),
                topico.getStatus(),topico.getCurso(),topico.getCreatedAt()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico= topicorRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();

    }


    @GetMapping("/{id}")

    public ResponseEntity <DatosRespuestaTopico>retornaDatosTopico(@PathVariable Long id){
        Topico topico= topicorRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico.getId(),topico.getNombre(),topico.getTitulo(),topico.getMensaje(),
                topico.getStatus(),topico.getCurso(),topico.getCreatedAt());
        return ResponseEntity.ok(datosTopico);

    }

}
