package codegym.vn.repository;

import codegym.vn.bean.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);
//    void createOrUpdate(Product s);
    Product findById(String id);
    void deleteById(int id);
}
