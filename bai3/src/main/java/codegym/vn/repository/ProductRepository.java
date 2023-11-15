package codegym.vn.repository;

import codegym.vn.bean.Product;
import org.springframework.stereotype.Repository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private final String SELECT = "select * from product_t";
    private final String INSERT = "INSERT INTO `product`.`product_t` ( `name`, `price`, `detail`, `producer`) VALUES (?,?,?,?);\n";
    private final String SEARCH = "select * from product_t where id=?";
    private final String DELETE = "DELETE FROM product_t WHERE id = ?";

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        Connection con = BaseRepository.getConnection();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String detail = resultSet.getString("detail");
                String producer = resultSet.getString("producer");
                list.add(new Product(id,name,price,detail,producer));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public void save(Product product) {
        Connection con = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(INSERT);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setString(3,product.getDetail());
            preparedStatement.setString(4,product.getProducer());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(String id) {
        Connection conn = BaseRepository.getConnection();
        Product product = new Product();
        try {
            PreparedStatement ps = conn.prepareStatement(SEARCH);
            ps.setString(1,id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String detail = resultSet.getString("detail");
                String producer = resultSet.getString("producer");
                product = new Product(name,price,detail,producer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(product);
        return product;
    }
    @Override
    public void deleteById(int id) {
        Connection con = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}