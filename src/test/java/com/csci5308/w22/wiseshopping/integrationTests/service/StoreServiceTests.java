package com.csci5308.w22.wiseshopping.integrationTests.service;

import com.csci5308.w22.wiseshopping.models.Location;
import com.csci5308.w22.wiseshopping.models.Merchant;
import com.csci5308.w22.wiseshopping.models.Store;
import com.csci5308.w22.wiseshopping.service.LocationService;
import com.csci5308.w22.wiseshopping.service.MerchantService;
import com.csci5308.w22.wiseshopping.service.StoreService;
import com.csci5308.w22.wiseshopping.utils.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author Elizabeth James
 */
//TODO: change profile to test later
@SpringBootTest
@ActiveProfiles(profiles = "dev")
public class StoreServiceTests {
    @Autowired
    private StoreService storeService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private LocationService locationService;


    @Test
    public void testAddStore() {

        Merchant merchant = merchantService.registerMerchant("dummy", "dummy@dummy.com", "dummy");
        Location  location =  locationService.addLocation("dummy","dummy","dummy","dummy");
        Store expectedStore  = new Store("Timbuktu", Util.parseTime("11"), Util.parseTime("12"), "private", "John Doe", location,merchant);

        Store actualStore = storeService.addStore("Timbuktu", "private", "11", "12", "John Doe", merchant,location);
        expectedStore.setStoreId(actualStore.getStoreId());
        Assertions.assertEquals(expectedStore, actualStore);
        storeService.remove(expectedStore);
        merchantService.removeMerchant("dummy@dummy.com");
        locationService.remove(location);
    }

    //Getting the user
    //Updating the user
    //Assert

}
