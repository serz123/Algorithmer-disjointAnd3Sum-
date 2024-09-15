package wqunionfind;

import java.util.List;
import timer.Timer;

public class WQUnionFindMeasuring {

    WQUnionFind wqUnionFind = new WQUnionFind();
    Timer timer = new Timer();
    
    public void test() {
        System.out.println("UNION");
        measureUnion(10, 5, 6);
        measureUnion(100, 5, 6);
        measureUnion(10000, 5, 6);
        measureUnion(100000, 5, 6);
        measureUnion(1000000, 5, 6);

        System.out.println();
        System.out.println("Multiple UNIONS");
        measureFewUnions(100, 5, 6, 2);
        measureFewUnions(100, 5, 6, 10);
        measureFewUnions(100, 5, 6, 100);
        measureFewUnions(100, 5, 6, 1000);


        System.out.println();
        System.out.println("FIND");
        measureFind(10, 5, 6);
        measureFind(100, 5, 6);
        measureFind(10000, 5, 6);
        measureFind(100000, 5, 6);
        measureFind(1000000, 5, 6);

        System.out.println();
        System.out.println("Multiple FINDS");
        measureFewFinds(100, 5, 6, 2);
        measureFewFinds(100, 5, 6, 10);
        measureFewFinds(100, 5, 6, 100);
        measureFewFinds(100, 5, 6, 10000);
    }

    public long measureUnion(int listSize, int a, int b) {
        int[] list = wqUnionFind.sets(listSize);
        Runnable setup = () -> {
            System.out.println("Initialization...");
        };

        Runnable testStatement = () -> {
            wqUnionFind.union(list, a, b);
        };

        long time = timer.timeit(testStatement, setup, 1);
        System.out.println("Time for union operation for list with size " + list.length + " afer one iteration: " + time + " ns");
        return time;
    }

    public long measureFewUnions(int listSize, int a, int b, int rep) {
        int[] list = wqUnionFind.sets(listSize);
        Runnable setup = () -> {};

        Runnable testStatement = () -> {
            wqUnionFind.union(list, a, b);
        };

        List<Long> time = timer.repeat(testStatement, setup, 1, rep);
        long sum = 0;
        for (long i : time) {
            sum += i;
        }
        System.out.println("Time for " + rep + " union operations for list with size 100 afer one iteration: " + sum + " ns");
        return sum;
    }


    // --------------> FIND <---------------------- //
    public long measureFind(int listSize, int a, int b) {
        int[] list = wqUnionFind.sets(listSize);
        Runnable setup = () -> {
            System.out.println("Initialization...");
        };

        Runnable testStatement = () -> {
            wqUnionFind.find(list, a, b);
        };

        long time = timer.timeit(testStatement, setup, 1);
        System.out.println("Time for Find operation for list with size " + list.length + " afer one iteration: " + time + " ns");
        return time;
    }

    public long measureFewFinds(int listSize, int a, int b, int rep) {
        int[] list = wqUnionFind.sets(listSize);
        Runnable setup = () -> {};

        Runnable testStatement = () -> {
            wqUnionFind.find(list, a, b);
        };

        List<Long> time = timer.repeat(testStatement, setup,1, rep);
        long sum = 0;
        for (long i : time) {
            sum += i;
        }
        System.out.println("Time for " + rep + " find operations for list with size 100 afer one iteration: " + sum + " ns");
        return sum;
    }

}
