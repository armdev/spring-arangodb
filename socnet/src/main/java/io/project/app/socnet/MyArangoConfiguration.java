/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.socnet;

import com.arangodb.ArangoDB;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author armena
 */
@Configuration
@EnableArangoRepositories(basePackages = {"io.project.app.socnet.repositories"})
public class MyArangoConfiguration implements ArangoConfiguration {

    @Override
    public ArangoDB.Builder arango() {
        return new ArangoDB.Builder()
                .host("localhost", 8529)
                .user("root")
                .password("root");
    }

    @Override
    public String database() {
        // Name of the database to be used
        return "socnetDB";
    }

}
