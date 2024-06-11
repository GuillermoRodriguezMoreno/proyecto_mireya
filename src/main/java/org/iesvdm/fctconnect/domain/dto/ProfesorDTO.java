package org.iesvdm.fctconnect.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfesorDTO {
    private String telefono;
    private String direccion;
    private String pathFoto;
}
