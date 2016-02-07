package com.vova_cons.Common.DocumentParser;

public interface Element {
    Element sub(String name);
    String getName();
    String getValue();
    boolean isComposite();
    boolean isArray();
}