//package guru.springframework.sfgpetclinic.controllers;
//
//import guru.springframework.sfgpetclinic.model.Owner;
//import guru.springframework.sfgpetclinic.services.OwnerService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.hamcrest.Matchers.*;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.ArgumentMatchers.isNotNull;
//import static org.mockito.Mockito.when;
//import static org.springframework.boot.test.mock.mockito.MockReset.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@ExtendWith(MockitoExtension.class)
//class OwnerControllerTest {
//
//    @Mock
//    OwnerService ownerService;
//
//    @InjectMocks
//    OwnerController ownerController;
//
//    Set<Owner> owners;
//
//    MockMvc mockMvc;
//
//    @BeforeEach
//    void setUp() {
//        owners = new HashSet<>();
//        owners.add(Owner.builder().id(1L).build());
//        owners.add(Owner.builder().id(2L).build());
//
//        mockMvc = MockMvcBuilders
//                .standaloneSetup(ownerController)
//                .build();
//    }
//
//    @Test
//    void listOwners() {
//        when(ownerService.findAll()).thenReturn(owners);
//
//        mockMvc.perform(get("/owners"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("owners/index"))
//                .andExpect(model().attribute("owners", hasSize(2)));
//    }
//
//    @Test
//    void listOwnersByIndex() throws Exception {
//        when(ownerService.findAll()).thenReturn(owners);
//
//        mockMvc.perform(get("/owners/index"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("owners/index"))
//                .andExpect(model().attribute("owners", hasSize(2)));
//    }
//
//    @Test
//    void findOwners() throws Exception {
//
//        mockMvc.perform(get())
//                .andExpect(status().isOk())
//                .andExpect(view().name("notImplemented"));
//
//    }
//
//    @Test
//    void displayOwner() throws Exception {
//        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
//
//        mockMvc.perform(get("/owners/123"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("owners/ownerDetails"))
//                .andExpect(model().attribute("owner", hasProperty("id", is(1l))));
//    }
//}