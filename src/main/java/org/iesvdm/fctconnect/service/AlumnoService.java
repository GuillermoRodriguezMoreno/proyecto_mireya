package org.iesvdm.fctconnect.service;

import org.iesvdm.fctconnect.domain.Alumno;
import org.iesvdm.fctconnect.domain.Usuario;
import org.iesvdm.fctconnect.domain.dto.AlumnoDTO;
import org.iesvdm.fctconnect.domain.dto.UsuarioDTO;
import org.iesvdm.fctconnect.exception.EntityNotFoundException;
import org.iesvdm.fctconnect.repository.AlumnoRepository;
import org.iesvdm.fctconnect.repository.CustomQueryBusquedaAlumnoImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;
    private final CustomQueryBusquedaAlumnoImpl customQuery;

    public AlumnoService(AlumnoRepository alumnoRepository, CustomQueryBusquedaAlumnoImpl customQuery) {
        this.alumnoRepository = alumnoRepository;
        this.customQuery = customQuery;
    }

    public List<Alumno> allActivos() {
        return this.alumnoRepository.findAllByActivoIsTrue();
    }

    public Map<String, Object> buscarAlumnoPaginacion(Optional<String> nombre,
                                                      Optional<Boolean> vehiculoPropio,
                                                      Optional<Long> idioma,
                                                      Optional<Integer> pagina,
                                                      Optional<Integer> tamanio) {
        return this.customQuery.buscarAlumnoPaginacion(nombre, vehiculoPropio, idioma, pagina, tamanio);
    }

    public Map<String, Object> buscarAlumnoInactivoPaginacion(Optional<String> nombre,
                                                      Optional<Boolean> vehiculoPropio,
                                                      Optional<Long> idioma,
                                                      Optional<Integer> pagina,
                                                      Optional<Integer> tamanio) {
        return this.customQuery.buscarAlumnoInactivosPaginacion(nombre, vehiculoPropio, idioma, pagina, tamanio);
    }


    public Alumno save(Alumno alumno) {
        return this.alumnoRepository.save(alumno);
    }

    public Alumno one(Long id) {
        return this.alumnoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Alumno.class));
    }


    public Alumno replaceAlumno(Long id, AlumnoDTO alumnoDTO) {
        return this.alumnoRepository.findById(id)
                .map(alumno -> {
                    alumno.setTelefono(alumnoDTO.getTelefono());
                    alumno.setDireccion(alumnoDTO.getDireccion());
                    alumno.setCarnetConducir(alumnoDTO.getCarnetConducir());
                    alumno.setVehiculoPropio(alumnoDTO.getVehiculoPropio());
                    alumno.setPathCV(alumnoDTO.getPathCV());
                    alumno.setPathExpediente(alumnoDTO.getPathExpediente());
                    alumno.setFormacion(alumnoDTO.getFormacion());
                    alumno.setPathFoto(alumnoDTO.getPathFoto());
                    return this.alumnoRepository.save(alumno);
                })
                .orElseThrow(() -> new EntityNotFoundException(id, Alumno.class));
    }



}



