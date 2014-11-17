package com.hypirion.bench.persistentvector;

import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Level;

import clojure.lang.PersistentVector;

@State(Scope.Benchmark)
public class Append {

    @Param({"1", "2", "3", "4", "5"})
    public int bits;
    int size;

    PersistentVector p;

    @Setup(Level.Trial)
    public void setup() {
        size = (1 << (5*bits)) + 64;
        p = PersistentVector.EMPTY;
        for (int i = 0; i < size; i++) {
            p = p.cons(new Object());
        }
    }

    @Benchmark
    public PersistentVector bencAppend() {
        return p.cons(new Object());
    }
}
