

import java.io.IOException;
import java.util.List;

import static chart.ChartTools.*;
import static tools.ProbTheoryTools.*;
import static tools.FileTools.*;
import static generator.Generator.*;

public class Samples {

    public static void main( String[] args ) throws IOException {

        String fileWithSequence = args[0];
        String fileWithGeneratedSequence = args[1];


        // Generate sequence and save it to the file
        /*
        List<Float> sequence = generateErlangRandomNumbers(4, 0.0154, 1, 1000, 300);
        writeSequenceToFile(sequence, fileWithGeneratedSequence);
        */

        // Read specified sequence from file
        List<Float> sequence = readSequenceFromFile(fileWithSequence, 300);

        // Read generated sequence from file
        //List<Float> sequence = readSequenceFromFile(fileWithGeneratedSequence, 300);


        // Get numerical characteristics of sequence
        /*
        System.out.println("Математическое ожидание: " + mathematicalExpectation(sequence));
        System.out.println("Дисперсия: " + dispersion(sequence));
        System.out.println("Средне квадратическое отклонение: " + standardDeviation(sequence));
        System.out.println("Коэфициент вариации: " + coefficientVariation(sequence) + "%");
        System.out.println("Доверительный интервал для доверительной вероятности 0.9: " + getConfidentialInterval(sequence, 0.9f));
        System.out.println("Доверительный интервал для доверительной вероятности 0.9: " + getConfidentialInterval(sequence, 0.95f));
        System.out.println("Доверительный интервал для доверительной вероятности 0.9: " + getConfidentialInterval(sequence, 0.99f));
        */

        // Show sequence chart
        //showChart(sequence, "График последовательности", "Индекс", "Значение", 1);

        // Auto correlation analysis
        /*
        List<Float> res = calculateAutoCorrelation(sequence, 10);

        for(int i = 0; i < res.size(); i++) {
            System.out.println("Лаг " + (i+1) + ": Коэффициент автокорреляции = " + res.get(i));
        }

        showChart(res, "Автокорреляция для заданной числовой последовательности", "Лаг", "Коэффициент автокорреляции", 1);
        */

        // Show histogram of frequency distribution
        //showDiagramWithBins(splitToIntervalsAndCountFrequency(sequence, 10), "Гистограмма распределения частот", "Интервалы", "Частоты");

        // Calculate correlation of specified and generated sequences
        /*
        List<Float> specifiedSequence = readSequenceFromFile(fileWithSequence, 300);
        List<Float> generatedSequence = readSequenceFromFile(fileWithGeneratedSequence, 300);
        float corr = calculateCorrelation(specifiedSequence, generatedSequence);
        System.out.println("Коэффициент корреляции сгенерированной и заданной последовательности: " + corr);
        */

        // Approximate Erlang distribution coefficients
        /*
        var params = approximateToErlangDistribution(sequence);
        System.out.println("Апроксимированные параметры распределения Эрланга:");
        System.out.println("k = " + params.getK());
        double roundedAlpha = ((int)(params.getAlpha() * 10000))/10000d;
        System.out.println("alpha = " + roundedAlpha);
        */

        // Calculate Erlang 4th order density and show it's chart
        /*
        List<Float> density = computeErlangDensity(generateIntegerList(30, 800), params.getK(),roundedAlpha);

        showChart(density, "График функции плотности", "x", "f(x)", 30);
        */
    }

}
