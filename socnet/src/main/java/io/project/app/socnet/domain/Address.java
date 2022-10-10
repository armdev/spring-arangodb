/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.socnet.domain;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Field;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 *
 * @author armena
 */
@Document(collection = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = -7340797464295033378L;

    @Id
    private String id;

    @ArangoId
    private String arangoId;

    @Field
    private String address;

}
