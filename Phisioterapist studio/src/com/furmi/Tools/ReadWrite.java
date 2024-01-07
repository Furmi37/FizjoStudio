package com.furmi.Tools;

import java.io.*;

public class ReadWrite {
    private String fileName = "/Users/furm/Desktop/java/Phisioterapist studio/docs/studio.txt";
    private File file = new File(fileName);
    public void writeToFile(String s){
        checkOrCreateFile();
        try(
                var fileWriter = new FileWriter(file,true);
                var writer = new BufferedWriter(fileWriter);
                ) {
            writer.write(s);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFromFile(){
        checkOrCreateFile();
        try(var fileReader = new FileReader(file);
            var reader = new BufferedReader(fileReader);
            ){
            String nextLine;
            while((nextLine = reader.readLine()) != null){
                System.out.println(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void checkOrCreateFile (){
        boolean fileExists = file.exists();
        if(!fileExists){
            try {
                fileExists = file.createNewFile();
            } catch (IOException e) {
                System.out.println("Failed to create a file");
            }
        }
    }

}
