package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.phongban;
import com.example.demo.repository.Iphongbanrepository;



@Service
public class phongbanservice {
    @Autowired
    private Iphongbanrepository Iphongbanrepository;

    public List<phongban> getAllphongban(){
        return Iphongbanrepository.findAll();
    }

    // public phongban getphongbanbyid(Long id){
    //     return Iphongbanrepository.findById(id).orElse(null);
    // }

    public void addPhongban(phongban phongban){
        Iphongbanrepository.save(phongban);
    }

    public void deleteBook(Long id){
        Iphongbanrepository.deleteById(id);
    }

    public void updateBook(phongban phongban){
        Iphongbanrepository.save(phongban);
    }
}
