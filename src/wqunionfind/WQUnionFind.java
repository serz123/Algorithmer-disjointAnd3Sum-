package wqunionfind; 

public class WQUnionFind {

    private int[] size;

    public int[] sets(int numElements) {
        int[] list = new int[numElements];
        size = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            list[i] = i;
            size[i] = 1;
        }
        return list;
    }

    public void union(int[] list, int rootA, int rootB) {
        if (size[rootA] < size[rootB]) {
            list[rootA] = list[rootB];
            size[rootB] += size[rootA];
        } else {
            list[rootB] = list[rootA];
            size[rootA] += size[rootB];
        }
    }

    public boolean find(int[] list, int rootA, int rootB) {
        return list[rootA] == list[rootB];
    }
}
