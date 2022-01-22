package com.vin.casestudy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DoctorDto {

    @Id
    private Long id;
    private String name;
    private String spec;
    private String hsNm;
    private String hsLoc;
    private Boolean visit;
}

