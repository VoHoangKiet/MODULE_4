package codegym.vn.service;

import codegym.vn.bean.Product;
import codegym.vn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }


//    @Override
//    public void createOrUpdate(Product s) {
//        productRepository.createOrUpdate(s);
//    }
//
    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }
//
    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}