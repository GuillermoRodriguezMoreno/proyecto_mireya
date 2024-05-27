package org.iesvdm.fctconnect.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.fctconnect.domain.Solicitud;
import org.iesvdm.fctconnect.domain.dto.SolicitudDTO;
import org.iesvdm.fctconnect.service.SolicitudService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api/solicitudes")
public class SolicitudController {
    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }


//    @GetMapping(value = {"", "/"})
//    public List<Solicitud> all() {
//        log.info("Accediendo a todas las solicitudes");
//        return this.solicitudService.all();
//    }

    @GetMapping(value = { "/alu"})
    public List<Solicitud> allSolicitudesAlumno(String estado, String tipo, long id) {
        return this.solicitudService.allAlumno(estado, tipo, id);
    }

    @GetMapping(value = { "/emp"})
    public List<Solicitud> allSolicitudesEmpresa(String estado, String tipo, long id) {
        return this.solicitudService.allEmpresa(estado, tipo, id);
    }

    @PutMapping("/{id}")
    public Solicitud replaceSolicitud(@PathVariable("id") Long id, @RequestBody SolicitudDTO solicitudDTO) {
        return this.solicitudService.replace(id, solicitudDTO);
    }




    @PostMapping({"", "/"})
    public Solicitud newSolicitud(@RequestBody Solicitud solicitud) {
        return this.solicitudService.save(solicitud);
    }

    @GetMapping("/{id}")
    public Solicitud one(@PathVariable("id") Long id) {
        return this.solicitudService.one(id);
    }



    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteSolicitud(@PathVariable("id") Long id) {
        this.solicitudService.delete(id);
    }
}
