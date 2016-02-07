package com.vova_cons.Common.DocumentParser;

import java.util.Scanner;

class ParserImpl {
    Node root;

    public ParserImpl(String fileName){
        String fileContent = FileReader.get(fileName);
        root = new Node("document");
        parseForParent(root, fileContent);
    }

    private void parseForParent(Node parent, String content){
        //System.out.println("parse for parent: " + parent.getName());
        Scanner scanner = new Scanner(content);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            String name = getName(line);
            if (isIncludeOpenSkobs(line)) {
                parent.addChildren(createNode(name, getContentForNode(scanner)));
                //System.out.println("add children node for " + parent.getName());
            } else {
                parent.addChildren(createLeaf(name, line));
                //System.out.println("add children leaf for " + parent.getName());
            }
        }
    }

    private String getName(String line){
        return line.substring(0, line.indexOf(" "));
    }

    public Node createNode(String name, String content){
        Node node = new Node(name);
        parseForParent(node, content);
        return node;
    }
    private Element createLeaf(String name, String line) {
        String value = line.substring(line.indexOf(":")+2);
        return new Leaf(name, value);
    }

    private String getContentForNode(Scanner scanner){
        StringBuilder content = new StringBuilder();
        int openSkobsCounter = 0;
        while(true && scanner.hasNext()){
            String line = scanner.nextLine();
            if (isIncludeOpenSkobs(line))
                openSkobsCounter++;
            if (isIncludeClosedSkobs(line)){
                if (openSkobsCounter == 0)
                    break;
                openSkobsCounter--;
            }
            content.append(line).append("\n");
        }
        return content.toString();
    }

    private boolean isIncludeOpenSkobs(String line){
        return line.indexOf("{") != -1;
    }

    private boolean isIncludeClosedSkobs(String line){
        return line.indexOf("}") != -1;
    }

    public Element parse() {
        return root;
    }
}
