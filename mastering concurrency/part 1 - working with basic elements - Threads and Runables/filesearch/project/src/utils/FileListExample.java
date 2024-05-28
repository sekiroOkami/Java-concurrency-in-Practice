package utils;

import java.io.File;

public class FileListExample {
    public static void main(String[] args) {

        // path
        File directory = new File(".\\src\\utils");

        // check if the path is a directory
        if (directory.isDirectory()) {

            //Obtain a list of files in the directory
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file: files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("No files found in the directory");
            }
        } else {
            System.out.println("Specified path is not a directory");
        }
    }
}
