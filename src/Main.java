import chart.*;
import javax.swing.*;
import threesum.ThreeSumCachingMeasuring;
import unionfind.UnionFindMeasuring;
import wqunionfind.WQUnionFindMeasuring;


public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ChartUnion example = new ChartUnion("Union");
            example.setSize(800, 600);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });

        SwingUtilities.invokeLater(() -> {
            ChartSeveralUnions example = new ChartSeveralUnions("Several Unions");
            example.setSize(800, 600);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });


        SwingUtilities.invokeLater(() -> {
            ChartFind example = new ChartFind("Find");
            example.setSize(800, 600);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });

        SwingUtilities.invokeLater(() -> {
            ChartSeveralFinds example = new ChartSeveralFinds("Several Finds");
            example.setSize(800, 600);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });

        SwingUtilities.invokeLater(() -> {
            Chart3Sum example = new Chart3Sum("Three sum");
            example.setSize(800, 600);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });


        System.out.println("-----> Union find <-----");
        System.out.println();
        UnionFindMeasuring unionFindTests = new UnionFindMeasuring();
        unionFindTests.test();
        System.out.println();

        System.out.println();
        System.out.println("-----> Weighted quick union find <-----");
        System.out.println();
        WQUnionFindMeasuring wqUnionFindTests = new WQUnionFindMeasuring();
        wqUnionFindTests.test();


        System.out.println();
        System.out.println("-----> Three sum <-----");
        System.out.println();
        ThreeSumCachingMeasuring threeSumCachingMeasuring = new ThreeSumCachingMeasuring();
        threeSumCachingMeasuring.test();
    }
}
