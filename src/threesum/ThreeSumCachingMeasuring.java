package threesum;

import assets.RandomListGenerator;
import java.util.List;
import timer.Timer;

public class ThreeSumCachingMeasuring {

    RandomListGenerator randomListGenerator = new RandomListGenerator();
    ThreeSumCaching threeSumCaching = new ThreeSumCaching();
    Timer timer = new Timer();

    public void test() {
        threeSum(1);
        threeSum(2);
        threeSum(10);
        threeSum(20);
        threeSum(50);
        threeSum(100);
        threeSum(200);
        threeSum(500);
        threeSum(1000);
        threeSum(2000);
    }

    public long threeSum(int size) {
        List<Integer> list = randomListGenerator.createRandomList(size, -8, 5);
        Runnable setup = () -> {
            System.out.println("Initialization...");
        };

        Runnable testStatement = () -> {
            threeSumCaching.getTreeSum(list);
        };

        long time = timer.timeit(testStatement, setup, 1);
        System.out.println("Time for Three Sum operation for list with size " + size +" afer one iteration: " + time + " ns");
        return time;
    }
}
