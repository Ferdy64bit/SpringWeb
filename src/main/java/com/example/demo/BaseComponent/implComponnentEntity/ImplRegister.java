package com.example.demo.BaseComponent.implComponnentEntity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@NoArgsConstructor
@Component
@Setter
@Entity(name = "register")
public class ImplRegister{

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "firstname")
    private String firstName;

    @NotBlank
    @Column(name = "lastname")
    private String lastName;

    @NotBlank
    @Id

    private String email;

    @NotBlank
    private String phone;

    private String time;

    @Override
    public String toString() {
        return "ImplRegister{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
