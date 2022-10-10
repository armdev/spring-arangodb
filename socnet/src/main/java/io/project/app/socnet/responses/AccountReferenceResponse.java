/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.socnet.responses;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author armena
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountReferenceResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -6530496350804611240L;

    private String id;      
    private String arangoId; 
    private String name;  
    private String addressArangoId;
    private String addressName;


}
