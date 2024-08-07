package com.maids.cc.Library.Management.System.repository;

import com.maids.cc.Library.Management.System.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
