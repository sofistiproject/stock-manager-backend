package com.sofisticat.stockmanagerbackend.database.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sofisticat.stockmanagerbackend.dto.ProductDTO;
import com.sofisticat.stockmanagerbackend.model.product.Product;
import com.sofisticat.stockmanagerbackend.model.product.ProductDetail;
import com.sofisticat.stockmanagerbackend.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class ProductManager implements ProductDatabase {
    private final String TABLE_NAME = "products";
    private final String ID = "id";
    private final String NAME = "name";
    private final String PRICE = "price";
    private final String DETAILS = "details";

    @Autowired
    Connection connection;


    public int insertProduct(ProductDTO product) {
        String sql = "INSERT INTO " + TABLE_NAME
            + "(" + NAME + ", " + PRICE + ", " + DETAILS + ")"
            + "VALUES (?, ?, to_json(?::json)) ";
        int countRow = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, Utils.SystemMapper().writeValueAsString(product.getDetails()));
            countRow = ps.executeUpdate();
        } catch (JsonProcessingException | SQLException e) {
            e.printStackTrace();
        }
        return countRow;
    }

    public Product getProductByName() {
        // TODO: Find product by name
        return new Product();

    }

    public void updateProduct() {
        // TODO: update product
    }


    public Optional<Product> findProductById(String uuid) {
        String sql = String.format("SELECT %s,%s,%s,%s FROM products WHERE %s::text = ?", ID, NAME, PRICE, DETAILS, ID);
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, uuid);
            ResultSet resultSet = ps.executeQuery();
            Optional<Product> product = productMapper(resultSet);
            return Optional.ofNullable(product.orElseThrow(() -> new RuntimeException("Not Found")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<Product> productMapper(ResultSet rs) {
        try {
            while (rs.next()) {
                String uuid = rs.getString("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                ProductDetail detail = Utils.SystemMapper()
                    .readValue(rs.getString("details"),ProductDetail.class);
                Product product = new Product(uuid, name, price, detail);
                return Optional.of(product);
            }
        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
