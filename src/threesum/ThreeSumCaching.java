package threesum;

import java.util.ArrayList;
import java.util.List;

public class ThreeSumCaching {
    
    public ArrayList<ArrayList<Integer>> getTreeSum(List<Integer> list) {
    
        ArrayList<ArrayList<Integer>> response = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> cache = new ArrayList<>();
            for (int j = i + 1; j < list.size(); j++) {
                if (cache.contains(-(list.get(i) + list.get(j)))) {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(list.get(i));
                    triplet.add(list.get(j));
                    triplet.add(-(list.get(i) + list.get(j)));
                    response.add(triplet);
                } else {
                    cache.add(list.get(j));
                }
            }
        }
        return response;
    }
}
