package org.iesvdm.fctconnect.repository;


import org.iesvdm.fctconnect.domain.ProfesorTutorizaAlumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorTutorizaAlumnoRepository extends JpaRepository<ProfesorTutorizaAlumno, Long> {

}
