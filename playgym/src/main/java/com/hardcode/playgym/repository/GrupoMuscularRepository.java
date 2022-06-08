package com.hardcode.playgym.repository;

import com.hardcode.playgym.entity.GrupoMuscular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoMuscularRepository extends JpaRepository<GrupoMuscular, Long> {

}
