/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.io.Serializable;

/**
 *
 * @author macbook
 */
public class TreeNode implements Serializable {
    Bus info;
    TreeNode left;
    TreeNode right;
    public static final long serialVersionUID = 1L;


    public TreeNode(Bus x) {
        info = x;
        left = null;
        right = null;
    }

    
    
    
}
