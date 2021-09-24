package com.p5.adoptions.unittests;

import com.p5.adoptions.repository.shelters.AnimalShelter;
import com.p5.adoptions.repository.shelters.AnimalShelterRepository;
import com.p5.adoptions.service.AnimalShelterService;
import com.p5.adoptions.service.DTO.ShelterDTO;
import com.p5.adoptions.service.adapters.ShelterAdapter;
import com.p5.adoptions.service.exceptions.ShelterLocationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

public class AnimalShelterServiceTests {

    private ShelterDTO shelterDTO;
    private AnimalShelter shelter;
    @BeforeEach
    public void setUp(){
        this.shelterDTO = new ShelterDTO();
        shelterDTO.setId(1);
        shelterDTO.setName("shelter1");
        shelterDTO.setLocation("Iasi");
        shelterDTO.setCats(Collections.emptyList());
        shelterDTO.setDogs(Collections.emptyList());

        this.shelter = ShelterAdapter.toEntity(shelterDTO);
    }
    @Test
    public void validateShelterTest_ok(){
        AnimalShelterService animalShelterService = new AnimalShelterService(null);
        animalShelterService.validateShelterLocation(shelterDTO);
    }

    @Test
    public void validateShelterTest_fails(){
        AnimalShelterService animalShelterService = new AnimalShelterService(null);
        shelterDTO.setLocation("Iasiiii");
        ShelterLocationException exception = Assertions.assertThrows(ShelterLocationException.class,
                () -> animalShelterService.validateShelterLocation(shelterDTO));
    }

    @Test
    public void createShelter_savesOk(){
        AnimalShelterRepository animalShelterRepositoryMock = Mockito.mock(AnimalShelterRepository.class);
        AnimalShelterService animalShelterService = new AnimalShelterService(animalShelterRepositoryMock);
        Mockito.when(animalShelterRepositoryMock.save(Mockito.any())).thenReturn(shelter);
        ShelterDTO savedShelter = animalShelterService.createShelter(shelterDTO);
        Assertions.assertNotNull(savedShelter);
        Assertions.assertEquals(savedShelter, shelterDTO);


    }
}
