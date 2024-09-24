package tools;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;


public class ProbTheoryTools {

    // returns float value as a percentage
    public static float relativeDeviation(float standard, float value){
        return standard > value ? Math.abs((standard - value) / standard) * 100 :
                Math.abs((value - standard) / value) * 100;
    }

    // returns float value as a percentage
    public static float intervalRelativeDeviation(float[] standard, float[] value){
        float standardMean = standard[1] / standard[0];
        float valueMean = value[1] / value[0];

        float tmp = standardMean > valueMean ? (standardMean - valueMean) / standardMean
                : (valueMean - standardMean) / valueMean;

        return Math.abs(tmp) * 100;
    }

    public static float dispersion(List<? extends Number> list){
        int length = list.size();

        if (length < 2) {
            throw new IllegalArgumentException("List size must be at least 2");
        }

        float mathematicalExpectation = mathematicalExpectation(list);

        float sumOfSquares = 0;

        for (Number num : list) {
            float deviation = num.floatValue() - mathematicalExpectation;
            sumOfSquares += deviation * deviation;
        }

        return sumOfSquares / (length - 1);

    }

    public static float mathematicalExpectation(List<? extends Number> list) {
        int length = list.size();

        if (length == 0) return 0;
        if (length == 1) return list.get(0).floatValue();

        float sum = 0;

        for (Number num : list) {
            sum += num.floatValue();
        }

        return sum / length;
    }

    public static float standardDeviation(List<? extends Number> list) {

        float dispersion = dispersion(list);

        return (float) Math.sqrt(dispersion);

    }

    public static double coefficientVariation(List<? extends Number> list) {

        float standardDeviation = standardDeviation(list);

        float mathematicalExpectation = mathematicalExpectation(list);


        return (standardDeviation / mathematicalExpectation) * 100;

    }

    public static String getConfidentialInterval(List<? extends Number> list, float confidenceLevel) {
        int length = list.size();
        float mathematicalExpectation = mathematicalExpectation(list);
        float standardDeviation = standardDeviation(list);

        float tmp = (getCriticalValue(confidenceLevel) * standardDeviation) / (float) Math.sqrt(length);
        float roundedTmp = Math.round(tmp * 1000) / 1000.0f;
        float roundedMathematicalExpectation = Math.round(mathematicalExpectation * 1000) / 1000.0f;
        return roundedMathematicalExpectation + " +- " + roundedTmp;
    }

    private static float getCriticalValue(float confidenceLevel) {

        if (confidenceLevel == 0.95f) {
            return 1.96f;
        } else if (confidenceLevel == 0.99f) {
            return 1.645f;
        }  else if(confidenceLevel == 0.9f) {
            return 2.576f;
        } else {
            throw new IllegalArgumentException("Unsupported confidence level");
        }
    }

    public static float calculateCorrelation(List<Float> sequence1, List<Float> sequence2) {

        PearsonsCorrelation correlation = new PearsonsCorrelation();

        double[] xArray = sequence1.stream().mapToDouble(Float::doubleValue).toArray();
        double[] yArray = sequence2.stream().mapToDouble(Float::doubleValue).toArray();

        return (float) correlation.correlation(xArray, yArray);

    }


    public static List<Float> calculateAutoCorrelation(List<Float> timeSeries, int maxLag) {
        List<Float> autoCorrelation = new ArrayList<>();
        PearsonsCorrelation correlation = new PearsonsCorrelation();

        for (int lag = 1; lag <= maxLag; lag++) {
            List<Float> x = new ArrayList<>();
            List<Float> y = new ArrayList<>();

            for (int i = 0; i < timeSeries.size() - lag; i++) {
                x.add(timeSeries.get(i));
                y.add(timeSeries.get(i + lag));
            }

            double[] xArray = x.stream().mapToDouble(Float::doubleValue).toArray();
            double[] yArray = y.stream().mapToDouble(Float::doubleValue).toArray();

            float corr = (float) correlation.correlation(xArray, yArray);
            autoCorrelation.add(corr);
        }

        return autoCorrelation;
    }

    public static List<Float> computeErlangDensity(List<Integer> xValues, int k, double lambda) {
        List<Float> densities = new ArrayList<>();
        for (int x : xValues) {
            float density = (float)((Math.pow(lambda, k) * Math.pow(x, k - 1) * Math.exp(-lambda * x)) / factorial(k - 1));
            densities.add(density);
        }
        return densities;
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public static List<Integer> generateIntegerList(int start, int end) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            integerList.add(i);
        }
        return integerList;
    }
}
