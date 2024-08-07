package com.maids.cc.Library.Management.System.repository;

import com.maids.cc.Library.Management.System.entities.Liberian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LiberianRepository extends JpaRepository<Liberian, Long> {
    Optional<Liberian> findByEmail(String email);
}
