package com.hardcode.playgym.repository;



import com.hardcode.playgym.entity.Asesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsesorRepository extends JpaRepository<Asesor, Long> {

    boolean existsByEmail(String email);
}
