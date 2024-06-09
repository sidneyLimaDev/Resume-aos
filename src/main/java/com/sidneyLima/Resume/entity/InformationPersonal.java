package com.sidneyLima.Resume.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.sidneyLima.Resume.dto.InformationPersonalDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "personal_informations")
@NoArgsConstructor
@AllArgsConstructor
public class InformationPersonal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String city;

    @OneToOne
    @JoinColumn(name = "resume_id")
    @JsonBackReference
    private Resume resume;

    public InformationPersonal(InformationPersonalDto PessoalinformacaoDto) {
        this.email = PessoalinformacaoDto.email();
        this.fullName = PessoalinformacaoDto.fullName();
        this.position = PessoalinformacaoDto.position();
        this.city = PessoalinformacaoDto.city();
        this.state = PessoalinformacaoDto.state();
        this.country = PessoalinformacaoDto.country();
    }
}
