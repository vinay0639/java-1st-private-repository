package com.vin.casestudy.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Doctor {

    @Max(150)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    @Column(unique = false, nullable = false)
    private String name;

    @NotBlank
    @NotNull
    @Column( nullable = false, unique = false)
    private String spec;

    @Column( nullable = true)
    private String hsNm;

    @Column( nullable = true, unique = false)
    private String hsLoc;

    @NotEmpty
    @NotNull
    @Column( nullable = false)
    private Boolean visit;
}
