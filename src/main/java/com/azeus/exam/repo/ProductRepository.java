package com.azeus.exam.repo;

import com.azeus.exam.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tiepnm on 9/19/2018.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
