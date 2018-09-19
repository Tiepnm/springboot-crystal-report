package com.azeus.exam.restful.controller;

import com.azeus.exam.dto.Product;
import com.azeus.exam.service.ProductService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by tiepnm on 9/19/2018.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    ExecutorService executors = Executors.newFixedThreadPool(5);

    @GetMapping
    public List<Product> findAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @PostMapping("/pdf")
    public ResponseEntity<String> exportPdfFile(@RequestBody String author) throws Exception {
        String fileName = "product.pdf";

        Future<String> future = executors.submit(() -> {
            try {

                InputStream reportInputStream = productService.exportPdf(author);
                FileUtils.copyInputStreamToFile(reportInputStream, new File("report" + File.separator + fileName));

                return fileName;
            } catch (Exception e) {
                return "error";
            }

        });
        return ResponseEntity
                .ok()
                .body(future.get(30, TimeUnit.SECONDS));
    }

}
