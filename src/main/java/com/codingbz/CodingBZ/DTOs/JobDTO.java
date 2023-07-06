package com.codingbz.CodingBZ.DTOs;

import jakarta.persistence.ElementCollection;
import lombok.Data;

import java.util.List;

@Data
public class JobDTO {
    private Long id;
    private String companyName;
    private String location;
    private String jobRole;
    private String jobDescription;

    @ElementCollection
    private List<String> skills;

    private int vacancies;
    private String salary;
}
