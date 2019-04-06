package com.example.validation5.entity;

import com.example.validation5.annotation.ValidPassword;
import com.example.validation5.annotation.ValidPesel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "")
    private String name;

    @NotBlank(message = "")
    private String surname;

    @Size(min = 2, max = 50, message = "Login moze miec od 2 do 50 znakow")
    @Column(unique = true)
    private String login;

    @ValidPassword
    //@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "niepoprawne haslo..")
    private String password;

    @Email(message = "")
    private String email;


    @NotNull(message = "")
    @Size(min = 11, max = 11)
    @Column(unique = true, updatable = false)
    @ValidPesel
    private String pesel;

    @Min(value = 10, message = "Wiek nie moze byc mniejszy niz 10")
    private int age;

}
