package com.mycompany.blockchainhw2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class readerAndWriter {

    static Gson gson = new Gson();

    public static void write(ArrayList<Block> blockChain) throws IOException {
        FileWriter myWriter = new FileWriter(getPath());
        myWriter.write(gson.toJson(blockChain));
        myWriter.close();
    }

    public static ArrayList<Block> read() throws IOException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(getPath()));
            ArrayList<Block> blockChain = new Gson().fromJson(reader, new TypeToken<ArrayList<Block>>() {
            }.getType());

            blockChain.forEach(el -> System.out.println(gson.toJson(el)));

            reader.close();
            return blockChain;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<Block>();
    }

    private static String getPath() {
        return new File("").getAbsolutePath() + "\\src\\data.json";
    }
}
