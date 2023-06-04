package com.example.demo.Service;
import com.example.demo.Model.nhanvien;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.Inahnvienrepository;

@Service
public class nhanvienService {
    @Autowired
    private Inahnvienrepository nInahnvienrepository;

    public List<nhanvien> getALLNhanvien(){
        return nInahnvienrepository.findAll();
    }

    public nhanvien getnhanvienbyid(String id){
        return nInahnvienrepository.findById(id).orElse(null);    }

    public void addNhanvien(nhanvien book){
        nInahnvienrepository.save(book);
    }

    public void deleteBook(String id){
        nInahnvienrepository.deleteById(id);
    }

    public void updateBook(nhanvien nhanviens){
        nInahnvienrepository.save(nhanviens);
    }
}
