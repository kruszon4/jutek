package com.jutek.JUTEK.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @NotNull(message = "Nie może być puste")
    @Size(min=2, max=30, message = "Imię musi zawierać conajmniej 2 znaki")
    private String name;

    @NotNull(message = "Nie może być puste")
    @Size(min=2, max=30, message = "Login musi zawierać conajmniej 2 znaki")
    private String login;

    @NotNull(message = "Nie może być puste")
    @Size(min=2, max=30, message = "Hasło musi zawierać conajmniej 2 znaki")
    private String password;

    @NotNull(message = "Nie może być puste")
    @Size(min=2, max=30, message = "Nazwisko musi zawierać conajmniej 2 znaki")
    private String lastName;

    private String userID;

}
