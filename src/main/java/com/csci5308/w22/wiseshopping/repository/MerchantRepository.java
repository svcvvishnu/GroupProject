package com.csci5308.w22.wiseshopping.repository;

import com.csci5308.w22.wiseshopping.models.Merchant;
import com.csci5308.w22.wiseshopping.models.Product;
import com.csci5308.w22.wiseshopping.models.ProductInventory;
import com.csci5308.w22.wiseshopping.models.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Elizabeth James
 */
@Repository
public interface MerchantRepository extends CrudRepository<Merchant,Integer> {
     Integer deleteByEmail(String email);
}
