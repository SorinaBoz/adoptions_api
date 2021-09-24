package com.p5.adoptions.service.DTO;

import com.p5.adoptions.service.validations.OnCreate;
import com.p5.adoptions.service.validations.OnUpdate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShelterDTO {
    @Null (message = "Id must be null for creation", groups = OnCreate.class)
    @NotNull (message = "Id must have value for update", groups = OnUpdate.class)
    @Min(value = 1, groups = OnUpdate.class)
    private Integer id;

    @NotNull
    @NotBlank
    private String name;

    private String location;
    private List<CatDTO> cats = new ArrayList<>();
    private List<DogDTO> dogs = new ArrayList<>();

    public ShelterDTO() {
    }

    public ShelterDTO(Integer id, String name, String location, List<CatDTO> cats, List<DogDTO> dogs) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.cats = cats;
        this.dogs = dogs;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<CatDTO> getCats() {
        return cats;
    }

    public void setCats(List<CatDTO> cats) {
        this.cats = cats;
    }

    public List<DogDTO> getDogs() {
        return dogs;
    }

    public void setDogs(List<DogDTO> dogs) {
        this.dogs = dogs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShelterDTO that = (ShelterDTO) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
