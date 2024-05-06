import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        //PART 0

        int numElements = 100000;

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        DecimalFormat formatter = new DecimalFormat("#,###");

        // Test insertion into beginning for ArrayList
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            arrayList.add(0, i);
        }
        long endTime = System.nanoTime();
        System.out.println("ArrayList insertion into beginning time: " + formatter.format(endTime - startTime) + " ns");

        // Test insertion into beginning for LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            linkedList.add(0, i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList insertion into beginning time: " + formatter.format(endTime - startTime) + " ns");

        // Test get operation for ArrayList
        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList get operation time: " + formatter.format(endTime - startTime) + " ns");

        // Test get operation for LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList get operation time: " + formatter.format(endTime - startTime) + " ns");

        // Test remove operation for ArrayList
        startTime = System.nanoTime();
        while (!arrayList.isEmpty()) {
            arrayList.remove(0);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList remove operation time: " + formatter.format(endTime - startTime) + " ns");

        // Test remove operation for LinkedList
        startTime = System.nanoTime();
        while (!linkedList.isEmpty()) {
            linkedList.remove(0);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList remove operation time: " + formatter.format(endTime - startTime) + " ns");

    }
}