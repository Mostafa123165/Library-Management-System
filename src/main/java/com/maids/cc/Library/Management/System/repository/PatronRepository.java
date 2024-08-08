package com.maids.cc.Library.Management.System.repository;

import com.maids.cc.Library.Management.System.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long> {
    Optional<Patron> findByPhone(String phone);
    Optional<Patron> findByEmail(String email);
}
