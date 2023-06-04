package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Data
@Entity
@Table(name = "nhanvien")
public class nhanvien {
    @Id
    @Column(name = "manv", length = 50, nullable = false, unique = true)
    @NotEmpty(message = "manv không được để trống")
    @Size(max = 50, message = "mavv không vượt quá 50 ký tự")
    private String id;

    @Column(name = "tennhanvien")
    @NotEmpty(message = "hoten không được để trống")

    @Size(max = 50, min = 1, message = "Title must be less tuan 50 characters")
    private String tennhanvien;

    @Column(name = "phai")
    @Size(max = 3, message = "Title must be less tuan 50 characters")
    private String phai;

    @Column(name = "noisinh")

    private String noisinh;
    @Column(name = "luong")
    private int luong;
    @ManyToOne
    @JoinColumn(name ="phongban_id")
    private phongban phongban;  

    
}
