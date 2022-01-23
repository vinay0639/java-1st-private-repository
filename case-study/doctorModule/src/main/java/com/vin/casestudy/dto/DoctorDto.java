package com.vin.casestudy.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DoctorDto {

    @Id
    private Long id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    @Column( nullable = false, unique = false)
    private String spec;

    @Column( nullable = true)
    private String hsNm;

    @Column( nullable = true, unique = false)
    private String hsLoc;

    @NotNull
    @Column( nullable = false)
    private Boolean visit;
}

