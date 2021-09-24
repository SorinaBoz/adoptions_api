package com.p5.adoptions.service.adapters;

import com.p5.adoptions.repository.cats.Cat;
import com.p5.adoptions.repository.dogs.Dog;
import com.p5.adoptions.service.DTO.CatDTO;
import com.p5.adoptions.service.DTO.DogDTO;

import java.util.List;
import java.util.stream.Collectors;

public class DogAdapter {
    public static DogDTO toDTO(Dog dog){
        DogDTO dogDTO = new DogDTO();
        dogDTO.setId(dog.getId());
        dogDTO.setName(dog.getName());
        dogDTO.setPhoto(dog.getPhoto());
        return dogDTO;
    }

    public static Dog toEntity(DogDTO dogDTO){
        Dog dog  = new Dog();
        dog.setId(dogDTO.getId());
        dog.setName(dogDTO.getName());
        dog.setPhoto(dogDTO.getPhoto());
        return dog;
    }

    public static List<DogDTO> toDogDTOList (List<Dog> dogList){
        return dogList.stream()
                .map(DogAdapter::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Dog> toDogList (List <DogDTO> dogDTOList){
        return dogDTOList.stream()
                .map(DogAdapter::toEntity)
                .collect(Collectors.toList());
    }
}
