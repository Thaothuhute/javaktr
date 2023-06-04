package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.nhanvien;
@Repository
public interface Inahnvienrepository extends JpaRepository<nhanvien,String> {
    
}
