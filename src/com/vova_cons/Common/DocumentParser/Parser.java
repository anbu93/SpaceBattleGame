package com.vova_cons.Common.DocumentParser;

public interface Parser {
    static Element parse(String fileName){
        return new ParserImpl(fileName).parse();
    }
}
