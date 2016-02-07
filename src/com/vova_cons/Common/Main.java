package com.vova_cons.Common;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Common.DocumentParser.Parser;

public class Main {
    public static void main(String[] args){
        Element document = Parser.parse("settings.txt");
        System.out.println(document.sub("rus").sub("game").sub("wave1").getValue());
    }
}
