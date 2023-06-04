package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "phongban")
public class phongban {
    @Id
    @Column(name = "mapb", length = 50, nullable = false, unique = true)
    @NotEmpty(message = "mapb không được để trống")
    @Size(max = 50, message = "mapb không vượt quá 50 ký tự")
    private String maphong;
    @Column(name = "tenphong")
    @NotEmpty(message = "hoten không được để trống")
    @Size(max = 50, min = 1, message = "Title must be less tuan 50 characters")
    private String tenphong;

}
