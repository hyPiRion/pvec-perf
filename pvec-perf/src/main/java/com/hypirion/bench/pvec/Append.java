package com.hypirion.bench.pvec;

import java.util.Random;
import com.hypirion.pvec.PVec;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Level;

@State(Scope.Benchmark)
public class Append {

    @Param({"1", "2", "3", "4", "5"})
    public int bits;
    int size;

    PVec p;

    @Setup(Level.Trial)
    public void setup() {
        size = (1 << (5*bits)) + 64;
        p = new PVec();
        for (int i = 0; i < size; i++) {
            p = p.push(new Object());
        }
    }

    @Benchmark
    public PVec benchAppend() {
        return p.push(null);
    }
}
