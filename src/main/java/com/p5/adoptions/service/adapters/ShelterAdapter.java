package com.p5.adoptions.service.adapters;

import com.p5.adoptions.repository.shelters.AnimalShelter;
import com.p5.adoptions.service.DTO.ShelterDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ShelterAdapter {

    public static ShelterDTO toDTO(AnimalShelter shelter){
        ShelterDTO shelterDTO = new ShelterDTO();
        shelterDTO.setId(shelter.getId());
        shelterDTO.setName(shelter.getName());
        shelterDTO.setLocation(shelter.getLocation());
        shelterDTO.setCats(CatAdapter.toCatDTOList(shelter.getCats()));
        shelterDTO.setDogs(DogAdapter.toDogDTOList(shelter.getDogs()));
        return shelterDTO;

    }

    public static AnimalShelter toEntity(ShelterDTO shelterDTO) {
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.setId(shelterDTO.getId());
        animalShelter.setName(shelterDTO.getName());
        animalShelter.setLocation(shelterDTO.getLocation());
        animalShelter.setCats(CatAdapter.toCatList(shelterDTO.getCats()));
        animalShelter.setDogs(DogAdapter.toDogList(shelterDTO.getDogs()));
        return animalShelter;


    }

    public static List<ShelterDTO> toDTOList (List<AnimalShelter> animalShelterList){
        return animalShelterList.stream()
                .map(ShelterAdapter::toDTO)
                .collect(Collectors.toList());
    }

    public static List<AnimalShelter> toEntityList (List<ShelterDTO> shelterDTOList){
        return shelterDTOList.stream()
                .map(ShelterAdapter::toEntity)
                .collect(Collectors.toList());
    }
}
