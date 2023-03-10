package com.example.regionkommune2v1.repository;

import com.example.regionkommune2v1.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KommuneRepository extends JpaRepository<Kommune, String> {

    Optional<Kommune> findByNavn(String navn);
    Optional<Kommune> findKommuneByNavn(String navn);
    List<Kommune> findKommuneByRegionKode(String kode);


}
