package com.azeus.exam.service;

import com.azeus.exam.dto.Product;

import java.io.InputStream;
import java.util.List;

/**
 * Created by tiepnm on 9/19/2018.
 */
public interface ProductService {
    public List<Product> getAllProducts();
    public InputStream exportPdf(String author) throws Exception;
}
