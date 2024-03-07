package com.example.demo.BaseComponent.implComponnentEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Generated
@Setter
@Entity(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Id
    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    private String hoby;

    @NotBlank
    private String alamat;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", hoby='" + hoby + '\'' +
                ", alamat='" + alamat + '\'' +
                '}';
    }
}
