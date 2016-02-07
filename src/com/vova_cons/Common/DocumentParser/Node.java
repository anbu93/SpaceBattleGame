package com.vova_cons.Common.DocumentParser;

import java.util.LinkedList;
import java.util.List;

class Node extends AbstractElement {
    private List<Element> childrens = new LinkedList<>();
    boolean isArray = false;

    public Node(String name) {
        super(name);
    }

    @Override
    public String getValue() {
        StringBuilder sb = new StringBuilder();

        for(Element element : childrens) {
            sb.append(element.getName()).append(" {\n");
            sb.append(element.getValue()).append("\n}\n");
        }
        return sb.toString(); // is composite Element!
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public Element sub(String name) {
        for(Element element : childrens)
            if (element.getName().equals(name))
                return element;
        return new Leaf(name, "This node not include this Element: " + name);
    }

    @Override
    public boolean isArray() {
        return isArray;
    }

    void addChildren(Element element){
        if (element.getName().equals("list"))
            isArray = true;
        childrens.add(element);
    }
}
