package com.p5.adoptions.service.adapters;

import com.p5.adoptions.repository.cats.Cat;
import com.p5.adoptions.repository.shelters.AnimalShelter;
import com.p5.adoptions.service.DTO.CatDTO;
import com.p5.adoptions.service.DTO.ShelterDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CatAdapter {
    public static CatDTO toDTO(Cat cat){
        CatDTO catDTO = new CatDTO();
        catDTO.setId(cat.getId());
        catDTO.setName(cat.getName());
        catDTO.setPhoto(cat.getPhoto());
        return catDTO;
    }

    public static Cat toEntity(CatDTO catDTO){
        Cat cat  = new Cat();
        cat.setId(catDTO.getId());
        cat.setName(catDTO.getName());
        cat.setPhoto(catDTO.getPhoto());
        return cat;
    }

    public static List<CatDTO> toCatDTOList (List<Cat> catList){
        return catList.stream()
                .map(CatAdapter::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Cat> toCatList (List<CatDTO> catDTOList){
        return catDTOList.stream()
                .map(CatAdapter::toEntity)
                .collect(Collectors.toList());
    }
}
