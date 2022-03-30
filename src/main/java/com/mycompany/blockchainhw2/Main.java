/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blockchainhw2;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdqa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BlockChain blockchain = new BlockChain();
            System.out.println("---------------------------");
            String[] arr1 = {"50: coinbase => abd"};
            blockchain.setBlock(new ArrayList<>(Arrays.asList(arr1)));
            String[] arr2 = {"20: abd => ahmed", "30: abd => sami"};
            blockchain.setBlock(new ArrayList<>(Arrays.asList(arr2)));
            String[] arr3 = {"10: sami => ahmed", "5: ahmed => abd"};
            blockchain.setBlock(new ArrayList<>(Arrays.asList(arr3)));
            blockchain.blocksExplorer();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
