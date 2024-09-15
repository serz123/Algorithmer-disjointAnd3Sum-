package assets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomListGenerator {

    public List<Integer> createRandomList(int size, int minValue, int maxValue) {
        List<Integer> randomList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int randomNum = random.nextInt(maxValue - minValue + 1) + minValue;
            randomList.add(randomNum);
        }

        return randomList;
    }
}
