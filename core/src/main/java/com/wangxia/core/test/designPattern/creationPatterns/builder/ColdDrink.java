package com.wangxia.core.test.designPattern.creationPatterns.builder;

public abstract class ColdDrink implements Item{

    @Override
    public Packing packing() {
        return new Bottle();
    }
}
