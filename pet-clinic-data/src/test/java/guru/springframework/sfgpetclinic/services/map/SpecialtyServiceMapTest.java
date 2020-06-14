package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SpecialtyServiceMapTest {

    SpecialtyServiceMap specialtyServiceMap;

    @BeforeEach
    void setUp() {
        specialtyServiceMap = new SpecialtyServiceMap();

        specialtyServiceMap.save(Speciality.builder().build());
    }

    @Test
    void findAll() {
        Set<Speciality> specialitySet = specialtyServiceMap.findAll();

        assertEquals(1, specialitySet.size());
    }

    @Test
    void deleteById() {
        specialtyServiceMap.deleteById(1L);

        assertEquals(0, specialtyServiceMap.findAll().size());
    }

    @Test
    void delete() {
        specialtyServiceMap.delete(specialtyServiceMap.findById(1L));

        assertEquals(0, specialtyServiceMap.findAll().size());
    }

    @Test
    void saveExistId() {
        Long id = 2L;

        Speciality speciality2 = Speciality.builder().build();
        Speciality savedSpeciality = specialtyServiceMap.save(speciality2);

        assertEquals(id, savedSpeciality.getId());
    }

    @Test
    void saveNoId(){

        Speciality savedSpeciality = specialtyServiceMap.save(Speciality.builder().build());

        assertNotNull(savedSpeciality);
        assertNotNull(savedSpeciality.getId());
    }

    @Test
    void findById() {
        Speciality speciality = specialtyServiceMap.findById(1L);

        assertEquals(1L, speciality.getId());
    }
}