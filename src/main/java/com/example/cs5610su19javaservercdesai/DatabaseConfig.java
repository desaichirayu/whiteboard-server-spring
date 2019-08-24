package com.example.cs5610su19javaservercdesai;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        HikariConfig config = new HikariConfig();
        URI dbUri = null;
        try{
            dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
        } catch (NullPointerException npe){
            System.out.println("ERROR: No ClearDB Database URL found, Switching to local");
        }

        if(dbUri != null) {
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
            System.out.println("Using Remote Database");
            config.setJdbcUrl(dbUrl);
            config.setUsername(username);
            config.setPassword(password);
        } else{
            System.out.println("Using local Database");
            config.setJdbcUrl("jdbc:mysql://localhost:3306/whiteboard");
            config.setUsername("root");
            config.setPassword("admin");
        }
        return new HikariDataSource(config);
    }
}
