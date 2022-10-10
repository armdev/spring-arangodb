/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.socnet.responses;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class AccountFriendResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -6530496350804611240L;

    private String id;      
    private String arangoId; 
    private String name;  
    private List<Friend> friendList = new ArrayList<>();
 


}
