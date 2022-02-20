package com.csci5308.w22.wiseshopping.service;

import com.csci5308.w22.wiseshopping.models.Merchant;
import com.csci5308.w22.wiseshopping.repository.MerchantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;


import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * @author Elizabeth James
 */
@ExtendWith(MockitoExtension.class)
public class MerchantServiceTests {
    @Mock
    private MerchantRepository mockedMerchantRepository;

    @InjectMocks
    private MerchantService merchantService;

    private Merchant merchant;

    @BeforeEach
    public void setUp(){
         merchant = new Merchant("John Doe", "johndoe@xyz.com", "password123");
    }

    @Test
    public void testRegisterMerchant() {
        when(mockedMerchantRepository.save(any(Merchant.class))).thenReturn(merchant);
        Merchant actualMerchant = merchantService.registerMerchant("John Doe", "johndoe@xyz.com", "password123");
        System.out.println(merchant);
        System.out.println(actualMerchant);
        Assertions.assertEquals(merchant, actualMerchant);
    }


    @Test
    public void testInputParametersForRegisterMerchant(){
        IllegalArgumentException exceptionForName1 = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.registerMerchant(null,"dummy","dummy"));
        Assertions.assertEquals("name cannot be null or empty or blank",exceptionForName1.getMessage());
        IllegalArgumentException exceptionForName2 = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.registerMerchant("","dummy","dummy"));
        Assertions.assertEquals("name cannot be null or empty or blank",exceptionForName2.getMessage());
        IllegalArgumentException exceptionForName3 = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.registerMerchant(" ","dummy","dummy"));
        Assertions.assertEquals("name cannot be null or empty or blank",exceptionForName3.getMessage());

        IllegalArgumentException exceptionForEmail1 = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.registerMerchant("dummy",null,"dummy"));
        Assertions.assertEquals("email cannot be null or empty or blank",exceptionForEmail1.getMessage());
        IllegalArgumentException exceptionForEmail2 = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.registerMerchant("dummy","","dummy"));
        Assertions.assertEquals("email cannot be null or empty or blank",exceptionForEmail2.getMessage());
        IllegalArgumentException exceptionForEmail3 = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.registerMerchant("dummy"," ","dummy"));
        Assertions.assertEquals("email cannot be null or empty or blank",exceptionForEmail3.getMessage());

        IllegalArgumentException exceptionForPassword1 = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.registerMerchant("dummy","dummy",null));
        Assertions.assertEquals("password cannot be null or empty or blank",exceptionForPassword1.getMessage());
        IllegalArgumentException exceptionForPassword2 = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.registerMerchant("dummy","dummy",""));
        Assertions.assertEquals("password cannot be null or empty or blank",exceptionForPassword2.getMessage());
        IllegalArgumentException exceptionForPassword3 = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.registerMerchant("dummy","dummy"," "));
        Assertions.assertEquals("password cannot be null or empty or blank",exceptionForPassword3.getMessage());

        IllegalArgumentException exceptionForEmail4 = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.registerMerchant("dummy","dummy","dummy"));
        Assertions.assertEquals("given email is not valid",exceptionForEmail4.getMessage());

    }

    @Test
    public void testRemoveMerchantForExistingRow(){
        when(mockedMerchantRepository.deleteByEmail(any(String.class))).thenReturn(1);
        Assertions.assertTrue(merchantService.removeMerchant("n@n.com"));
    }

    @Test
    public void testRemoveMerchantForNonExistingRow(){
        when(mockedMerchantRepository.deleteByEmail(any(String.class))).thenReturn(0);
        Assertions.assertFalse(merchantService.removeMerchant("n@n.com"));
    }

    @Test
    public void testInputParametersForRemoveMerchant(){
        IllegalArgumentException exceptionForEmail1 = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.registerMerchant("dummy",null,"dummy"));
        Assertions.assertEquals("email cannot be null or empty or blank",exceptionForEmail1.getMessage());
        IllegalArgumentException exceptionForEmail2 = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.registerMerchant("dummy","","dummy"));
        Assertions.assertEquals("email cannot be null or empty or blank",exceptionForEmail2.getMessage());
        IllegalArgumentException exceptionForEmail3 = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.registerMerchant("dummy"," ","dummy"));
        Assertions.assertEquals("email cannot be null or empty or blank",exceptionForEmail3.getMessage());

    }

    @Test
    public void testIllegalArgumentsRemoveNonExistingMerchant(){
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.removeMerchant(null));
        Assertions.assertEquals("email cannot be null or empty or blank",exception.getMessage());
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.removeMerchant(""));
        Assertions.assertEquals("email cannot be null or empty or blank",exception.getMessage());
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> merchantService.removeMerchant(" "));
        Assertions.assertEquals("email cannot be null or empty or blank",exception.getMessage());
    }


}