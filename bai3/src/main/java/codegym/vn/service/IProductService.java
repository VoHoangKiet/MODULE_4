package codegym.vn.service;

import codegym.vn.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);
//    void createOrUpdate(Product s);
//
    Product findById(String id);
//
    void deleteById(int id);
}