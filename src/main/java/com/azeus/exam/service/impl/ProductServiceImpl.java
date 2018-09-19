package com.azeus.exam.service.impl;

import com.azeus.exam.dto.Product;
import com.azeus.exam.repo.ProductRepository;
import com.azeus.exam.service.ProductService;
import com.crystaldecisions.reports.sdk.ReportClientDocument;
import com.crystaldecisions.sdk.occa.report.application.OpenReportOptions;
import com.crystaldecisions.sdk.occa.report.exportoptions.ReportExportFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiepnm on 9/19/2018.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        List<com.azeus.exam.entity.Product> productDBs = (List<com.azeus.exam.entity.Product>) productRepository.findAll();
        productDBs.forEach(product -> {
            Product productItem = new Product();
            BeanUtils.copyProperties(product, productItem);
            products.add(productItem);
        });
        return products;
    }

    @Override
    public InputStream exportPdf(String author) throws Exception {
        ReportClientDocument reportClientDoc = new ReportClientDocument();
        reportClientDoc.open("product.rpt", OpenReportOptions._openAsReadOnly);

        final List<Product> persons = getAllProducts();
        reportClientDoc.getDatabaseController().setDataSource(persons, Product.class, "Product", "Product");
        reportClientDoc.getDataDefController().getParameterFieldController().setCurrentValue("", "Author By", author);
        return reportClientDoc.getPrintOutputController().export(ReportExportFormat.PDF);
    }
}
