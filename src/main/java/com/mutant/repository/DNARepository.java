package com.mutant.repository;

import com.mutant.entity.DNAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DNARepository  extends JpaRepository<DNAEntity, String> {

    @Override
    List<DNAEntity> findAll();

    @Override
    Optional<DNAEntity> findById(String dna);
}
