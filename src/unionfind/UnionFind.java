package unionfind;

public class UnionFind {

    /**
     *
     * Construct the sets object.
     *
     * @param numElements the initial number of disjoint sets.
     */
    public int[] sets(int numElements) {
        int[] list = new int[numElements];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }
        return list;
    }

    public void union(int[] list, int a, int b) {
        int a_id = list[a];
        int b_id = list[b];

        for (int i : list) {
            if (i == a_id) {
                list[i] = b_id;
            }
        }
    }

    public boolean find (int[] list, int a, int b) {
        return list[a] == list[b];
    }
}
