package com.hardcode.playgym.service;

import com.hardcode.playgym.entity.Asesor;
import com.hardcode.playgym.entity.User;
import com.hardcode.playgym.repository.AsesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AsesorService {

    private final AsesorRepository asesorRepository;


    @Transactional
    public void create(Asesor asesorDto) {
        if (asesorRepository.existsByEmail(asesorDto.getEmail()))
            throw new IllegalArgumentException("There is already a user associated with the email entered");

        Asesor asesor = new Asesor();

        asesor.setAlias(asesorDto.getAlias());
        asesor.setEmail(asesorDto.getEmail());
        //asesor.setListaGrupoMuscular(); REVISAR IMPORTANTE
        asesor.setRol("ASESOR");

        asesorRepository.save(asesor);
    }

}
