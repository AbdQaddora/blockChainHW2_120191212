/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blockchainhw2;

import java.util.Date;

/**
 *
 * @author abdqa
 */
public class BlockHeader {

    String previousBlockHash, merkleRoot;
    int difficultyTarget, verison;
    long creatingTime, nonce;

    public BlockHeader(int difficultyTarget, int verison, String merkleRoot) {
        this.verison = verison;
        this.merkleRoot = merkleRoot;
        this.difficultyTarget = difficultyTarget;
        this.creatingTime = new Date().getTime();
        this.nonce = 0;
        this.previousBlockHash = "";
    }

    public void increaseNounce() {
        this.nonce = this.nonce + 1;
    }

    public void setPreviousBlockHash(String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }
}
