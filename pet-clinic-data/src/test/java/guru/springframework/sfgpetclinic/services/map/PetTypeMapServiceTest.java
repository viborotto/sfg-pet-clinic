package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PetTypeMapServiceTest {

    PetTypeMapService petTypeMapService;

    @BeforeEach
    void setUp() {
        petTypeMapService = new PetTypeMapService();

        petTypeMapService.save(PetType.builder().build());
    }

    @Test
    void findAll() {
        Set<PetType> petTypeSet = petTypeMapService.findAll();

        assertEquals(1, petTypeSet.size());
    }

    @Test
    void deleteById() {
        petTypeMapService.deleteById(1L);

        assertEquals(0, petTypeMapService.findAll().size());
    }

    @Test
    void delete() {
        petTypeMapService.delete(petTypeMapService.findById(1L));

        assertEquals(0, petTypeMapService.findAll().size());
    }

    @Test
    void saveExistId() {
        Long id = 2L;

        PetType petType2 = PetType.builder().build();
        PetType savedPetType = petTypeMapService.save(petType2);

        assertEquals(id, savedPetType.getId());
    }

    @Test
    void saveNoId(){

        PetType savedPetType = petTypeMapService.save(PetType.builder().build());

        assertNotNull(savedPetType);
        assertNotNull(savedPetType.getId());
    }

    @Test
    void findById() {
        PetType petType = petTypeMapService.findById(1L);

        assertEquals(1L, petType.getId());
    }
}