package com.hypirion.bench.pvec;

import java.util.Iterator;
import com.hypirion.pvec.PVec;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Level;

@State(Scope.Benchmark)
public class Iteration {

    @Param({"0", "1", "2", "3", "4", "5"})
    public int bits;
    int size;

    PVec p;

    @Setup(Level.Trial)
    public void setup() {
        size = (1 << (5*bits)) + 32;
        Integer ig = 4;
        p = new PVec();
        for (int i = 0; i < size; i++) {
            p = p.push(ig);
        }
    }

    @Benchmark
    public long benchForEach() {
        long sum = 0;
        for (Object o : p) {
            sum += (Integer) o;
        }
        return sum;
    }

    @Benchmark
    public long benchSeqGet() {
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += (Integer) p.get(i);
        }
        return sum;
    }
}
