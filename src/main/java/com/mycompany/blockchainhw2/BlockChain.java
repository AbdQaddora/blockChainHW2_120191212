/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blockchainhw2;

import com.google.gson.Gson;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author abdqa
 */
public class BlockChain {

    ArrayList<String> unconfirmedTransaction = new ArrayList<>();
    ArrayList<Block> blockchain;

    public BlockChain() throws IOException {
        this.blockchain = readerAndWriter.read();
    }

    public Block mineBlock(Block block) throws NoSuchAlgorithmException {
        String prefix = "";
        for (int x = 0; x < this.numberOfZeros(block.blockHeader.difficultyTarget); x++) {
            prefix += "0";
        }

        while (!Hash.sha256(new Gson().toJson(block.blockHeader)).substring(0, this.numberOfZeros(block.blockHeader.difficultyTarget)).equals(prefix)) {
            block.blockHeader.increaseNounce();
        }
        System.out.println(Hash.sha256(new Gson().toJson(block.blockHeader)));

        return block;
    }

    public void setBlock(ArrayList<String> transactions) throws NoSuchAlgorithmException, IOException {
        // create the block
        Block block = new Block(2, this.blockchain.size());
        if (block.height == 0) {
            block.blockHeader.setPreviousBlockHash("");
        } else {
            Block lastBlock = this.blockchain.get(this.blockchain.size() - 1);
            block.blockHeader.setPreviousBlockHash(Hash.sha256(new Gson().toJson(lastBlock.blockHeader)));
        }
        block.setTransactions(transactions);
        // mine the block
        block = this.mineBlock(block);
        this.blockchain.add(block);
        readerAndWriter.write(this.blockchain);
    }

    public Block getBlockByHash(String hash) throws NoSuchAlgorithmException {
        for (Block b : blockchain) {
            if (Hash.sha256(new Gson().toJson(b.blockHeader)).equals(hash)) {
                return b;
            }
        }
        throw new NullPointerException("block not exist");
    }

    public Block getBlockByHeight(int height) {
        return this.blockchain.get(height);
    }

    public void blocksExplorer() {
        System.out.println(new Gson().toJson(this.blockchain));
    }

    private int numberOfZeros(int x) {
        return (int) Math.ceil(log2(x) / 4) + 8;
    }

    private int log2(int N) {
        int result = (int) (Math.log(N) / Math.log(2));
        return result;
    }
}
