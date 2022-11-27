package com.socgen.labmanagement.web.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LabForm {
    private Long id;
    private String name;
    private String description;
    private Long category;
    private Long author;
}
