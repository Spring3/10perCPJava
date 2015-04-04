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

    private static final String pattern1 = "^((\\s+)?/[*]{1,2}).*$";
    private static final String pattern2 = ".*([*]{1,2}/)$";
    private static final String pattern3 = "^((\\s+)?/{2}).*$";
    private static final String pattern4 = "^[*].*$";

    public void cleanFile(File file){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file))))
        {
            File tempFile = new File(file.getName());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile)));
            String fileString;
            while((fileString = reader.readLine()) != null){
                String trimmedFileString = fileString.trim();
                boolean match1 = trimmedFileString.matches(pattern1);
                boolean match2 = trimmedFileString.matches(pattern2);
                boolean match3 = trimmedFileString.matches(pattern3);
                boolean match4 = trimmedFileString.matches(pattern4);

                if (match1 || match2 || match3 || match4){
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
