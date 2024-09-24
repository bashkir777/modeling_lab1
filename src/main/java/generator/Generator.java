package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Generator {
    public static List<Float> generateErlangRandomNumbers(int k, double lambda, double min, double max, int count) {
        Random random = new Random();
        List<Float> randomNumbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            float sum = 0.0f;
            for (int j = 0; j < k; j++) {
                float exponentialRandomValue =  (float) -Math.log(random.nextDouble()) / (float) lambda;
                sum += exponentialRandomValue;
            }
            sum = (float) Math.max(min, Math.min(max, sum));
            randomNumbers.add(sum);
        }

        return randomNumbers;
    }
}
