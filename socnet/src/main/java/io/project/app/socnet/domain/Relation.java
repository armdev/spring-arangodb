/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.socnet.domain;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author armena
 */
@Edge(collection = "relations")
@Data
@AllArgsConstructor
public class Relation implements Serializable {

    @Serial
    private static final long serialVersionUID = -7340797464295033378L;

    @Id
    private String id;

    @From
    private Account from;

    @To
    private Account ro;

}
