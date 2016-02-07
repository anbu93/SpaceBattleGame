package com.vova_cons.Common.DocumentParser;

abstract class AbstractElement implements Element {
    private String name;

    protected AbstractElement(String name){
        this.name = name;
    }

    @Override
    public Element sub(String name) {
        return new Leaf(name, "is not composite");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public boolean isArray() {
        return false;
    }
}
