package com.sofisticat.stockmanagerbackend.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfiguration extends AbstractJdbcConfiguration {

    @Value("${spring.datasource.url}")
    private String connectionUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    private Connection connection = null;
    // For Reference
    // https://www.postgresqltutorial.com/postgresql-jdbc/connecting-to-postgresql-database/
    @Bean
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(connectionUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
