package threesum;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

    public ArrayList<ArrayList<Integer>> getTreeSum(List<Integer> list) {
        ArrayList<ArrayList<Integer>> response = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list.size(); k++) {
                    if(i == j || i == k || j == k) {
                        continue;
                    }
                    int sum = list.get(i) + list.get(j) + list.get(k);
                    
                    // Ako zbir brojeva iznosi 0, dodaj u rezultat
                    if (sum == 0) {
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(list.get(i));
                        triplet.add(list.get(j));
                        triplet.add(list.get(k));
                        response.add(triplet);
                    }
                }
            }
        }
        return response;
    }
}

// TODO: CACHNING FÅR 3SUM ATT BLI KVADRATISK