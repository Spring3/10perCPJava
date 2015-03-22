package com.cp.task5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Created by user on 22.03.2015.
 */
public class Cleaner {

    public Cleaner() {
    }

    private static final String pattern = "(/[/*] (\\s?\\w+)?)|([*] (\\w+)?) ([*]/$)?";

    public void cleanFile(File file){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file))))
        {
            File tempFile = new File(file.getName());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile)));
            String fileString;
            while((fileString = reader.readLine()) != null){
                String trimmedFileString = fileString.trim();
                if (trimmedFileString.matches(pattern)){
                    continue;
                }
                writer.write(fileString);
                writer.newLine();
            }
            Path srcFilePath = file.toPath();
            reader.close();
            writer.flush();
            writer.close();
            Files.move(tempFile.toPath(), srcFilePath, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
