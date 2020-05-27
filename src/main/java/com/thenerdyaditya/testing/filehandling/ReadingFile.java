package com.thenerdyaditya.testing.filehandling;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReadingFile {

    public String scannerMethod() throws IOException {

        Resource resource = new ClassPathResource("files/random.txt");
        File file = resource.getFile();

        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(line);
        }
        return "Done";
    }

}
