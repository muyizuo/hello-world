package com.example.demo.base;

import lombok.Getter;
import lombok.Setter;

public class C_010 {

    public static void main(String[] args) {
        Base b = new Sub();
        System.out.println(b.getI());
    }
}

@Getter
@Setter
class Base {
    protected int i;
}

class Sub extends Base {
    {
        setI(5);
    }
}
