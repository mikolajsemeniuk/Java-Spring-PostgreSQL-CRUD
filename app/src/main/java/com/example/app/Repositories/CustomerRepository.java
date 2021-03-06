package com.example.app.repositories;

import com.example.app.entities.CustomerEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository 
    extends JpaRepository<CustomerEntity, Long> {

//    @Query("SELECT s FROM Student s WHERE s.email = ?1")
//    Optional<Student> findStudentByEmail(String email);
}
