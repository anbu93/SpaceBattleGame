package com.vova_cons.Common.DocumentParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileReader {
    static String get(String fileName){
        try {
            Scanner scanner = new Scanner(new File(fileName));
            return getContent(scanner);
        } catch (FileNotFoundException e) {
            return "error : not find file";
        }
    }

    private static String getContent(Scanner scanner){
        StringBuilder content = new StringBuilder();
        while(scanner.hasNextLine()) {
            String line = ignoreTabs(scanner.nextLine());
            if (line.equals("")) continue;
            content.append(line).append("\n");
        }
        //System.out.println(content.toString());
        return content.toString();
    }

    private static String ignoreTabs(String line){
        return line.substring(line.lastIndexOf("\t")+1);
    }
}
