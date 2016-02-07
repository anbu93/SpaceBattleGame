package com.vova_cons.Common.DocumentParser;

class Leaf extends AbstractElement {
    private String value;

    public Leaf(String name, String value) {
        super(name);
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
