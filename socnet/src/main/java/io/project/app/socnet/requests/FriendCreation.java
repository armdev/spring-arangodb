/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.socnet.requests;

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
public class FriendCreation implements Serializable {

    @Serial
    private static final long serialVersionUID = -6530496350804611240L;

    private String originId;
    
    private String targetId;

}
