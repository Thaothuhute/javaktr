package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.phongban;
@Repository
public interface Iphongbanrepository extends JpaRepository<phongban,Long> {
    
}
