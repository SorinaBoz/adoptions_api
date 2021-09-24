package com.p5.adoptions.service.DTO;

import com.p5.adoptions.service.validations.OnCreate;
import com.p5.adoptions.service.validations.OnUpdate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class CatDTO {
    @Null(message = "Id must be null for creation", groups = OnCreate.class)
    @NotNull(message = "Id must have value for update", groups = OnUpdate.class)
    @Min(value = 1, groups = OnUpdate.class)
    private Integer id;

    @NotNull
    @NotBlank
    private String name;
    private String photo;

    public CatDTO() {
    }

    public CatDTO(Integer id, String name, String photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
