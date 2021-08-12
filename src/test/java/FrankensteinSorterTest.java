import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class FrankensteinSorterTest {
    @Test
    public final void testSmall() {

        int[] size = new int[]{10, 100, 1000, 10000, 100000, 200000, 300000, 400000, 500000,
                600000, 700000, 800000, 900000, 1000000};

        for (int i = 0; i < size.length; i++) {
            int arr[] = new int[size[i]];
            for (int j = 0; j < arr.length; j++) {
                Random random = new Random();
                arr[j] = random.nextInt(10000);
            }
            long startTime = System.currentTimeMillis();
            arr = FrankensteinSorter.sort(arr);
            long endTime = System.currentTimeMillis();
            System.out.println("Total execution time, " + size[i] + ": " + (endTime - startTime) + "ms");
            //System.out.println(Arrays.toString(arr));

            for (int j = 1; j < arr.length; ++j) {
                assertTrue("Small test", arr[j - 1] <= arr[j]);
            }

        }
    }
}
