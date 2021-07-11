package main.service;

import java.util.Objects;

public class Pair {
    private String a;
    private String b;

    public Pair(String a, String b){
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        Pair pair1 = (Pair)this;
        Pair pair2 = (Pair) o;
        if(pair1.a.equals(pair2.a) && pair1.a.equals(pair2.a)){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
