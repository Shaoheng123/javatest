package org.example;

public class PassbyValuevsReference {

    public int[] testA(){
        Foo a = new Foo(1);
        Foo b = new Foo(1);
        b = new Foo(1);
        b.num++;
        return new int[]{a.getNum(),b.getNum()};

    }

}
