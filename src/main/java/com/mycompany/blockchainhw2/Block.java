/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blockchainhw2;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author abdqa
 */
public class Block {

    int blockSize, height, transactionsCounter;
    String merkleRoot;
    BlockHeader blockHeader;
    ArrayList<String> transactions;

    public Block(int blockSize, int height) {
        this.blockSize = blockSize;
        this.height = height;
        this.blockHeader = new BlockHeader(1, 1, "");
        this.transactions = new ArrayList<>();
        this.transactionsCounter = 0;
        this.merkleRoot = "";
    }

    public void setTransactions(ArrayList<String> transactions) throws NoSuchAlgorithmException {
        this.transactions = transactions;
        this.transactionsCounter = this.transactions.size();
        this.merkleRoot = this.calcMerkleRoot(transactions);
    }

    public String calcMerkleRoot(ArrayList<String> HashedTransactions) throws NoSuchAlgorithmException {
        ArrayList<String> temp = new ArrayList<>();
        if (HashedTransactions.size() != 1) {
            if (HashedTransactions.size() % 2 != 0) {
                HashedTransactions.add(HashedTransactions.get(HashedTransactions.size() - 1));
            }

            for (int x = 0; x < HashedTransactions.size(); x += 2) {
                temp.add(Hash.sha256(Hash.sha256(HashedTransactions.get(x)) + Hash.sha256(Hash.sha256(HashedTransactions.get(x + 1)))));
            }
            return this.calcMerkleRoot(temp);
        }
        return Hash.sha256(HashedTransactions.get(0));
    }
}
