package com.finance.app.repository;

import com.finance.app.models.Familias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FamiliasRepository extends JpaRepository<Familias, UUID> {
    Optional<Familias> findFamiliasByIdFamilia(int id);
    Optional<Familias> findFamiliasByidFamilia(int id);
}
