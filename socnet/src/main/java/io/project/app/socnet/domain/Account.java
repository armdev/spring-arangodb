/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.socnet.domain;

import com.arangodb.springframework.annotation.Document;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author armena
 */
@Document(collection = "account")
@Data
@AllArgsConstructor
public class Account implements Serializable {

    private static final long serialVersionUID = -7340797464295033378L;

    @Id
    private String id;    
    
    private String name;
    

}
