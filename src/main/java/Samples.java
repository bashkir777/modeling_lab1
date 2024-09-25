import chart.ChartTools;
import tools.FileTools;
import tools.ProbTheoryTools;

import java.io.IOException;
import java.util.List;

import static chart.ChartTools.showDiagramWithBins;


public class Samples {

    public static void main( String[] args ) throws IOException {

        String fileWithSequence = args[0];
        String fileWithGeneratedSequence = args[1];


        // Generate sequence and save it to the file
        /*
        List<Float> sequence = Generator.generateErlangRandomNumbers(4, 0.0154, 1, 1000, 300);
        FileTools.writeSequenceToFile(sequence, fileWithGeneratedSequence);
        */

        // Read specified sequence from file
        //List<Float> sequence = FileTools.readSequenceFromFile(fileWithSequence, 300);

        // Read generated sequence from file
        //List<Float> sequence = FileTools.readSequenceFromFile(fileWithGeneratedSequence, 300);


        // Get numerical characteristics of sequence
        /*
        System.out.println("Математическое ожидание: " + ProbTheoryTools.mathematicalExpectation(sequence));
        System.out.println("Дисперсия: " + ProbTheoryTools.dispersion(sequence));
        System.out.println("Средне квадратическое отклонение: " + ProbTheoryTools.standardDeviation(sequence));
        System.out.println("Коэфициент вариации: " + ProbTheoryTools.coefficientVariation(sequence) + "%");
        System.out.println("Доверительный интервал для доверительной вероятности 0.9: " + ProbTheoryTools.getConfidentialInterval(sequence, 0.9f));
        System.out.println("Доверительный интервал для доверительной вероятности 0.9: " + ProbTheoryTools.getConfidentialInterval(sequence, 0.95f));
        System.out.println("Доверительный интервал для доверительной вероятности 0.9: " + ProbTheoryTools.getConfidentialInterval(sequence, 0.99f));
        */

        // Show sequence chart
        //ChartTools.showChart(sequence, "График последовательности", "Индекс", "Значение", 1);

        // Auto correlation analysis
        /*
        List<Float> res = ProbTheoryTools.calculateAutoCorrelation(sequence, 10);

        for(int i = 0; i < res.size(); i++) {
            System.out.println("Лаг " + (i+1) + ": Коэффициент автокорреляции = " + res.get(i));
        }

        ChartTools.showChart(res, "Автокорреляция для заданной числовой последовательности", "Лаг", "Коэффициент автокорреляции", 1);
        */

        // Show histogram of frequency distribution
        //showDiagramWithBins(ChartTools.splitToIntervalsAndCountFrequency(sequence, 10), "Гистограмма распределения частот", "Интервалы", "Частоты");

        // Calculate Erlang 4th order density and show it's chart
        /*
        List<Float> density = ProbTheoryTools.computeErlangDensity(ProbTheoryTools.generateIntegerList(30, 800), 4,0.0154);

        ChartTools.showChart(density, "График функции плотности", "x", "f(x)", 30);
        */

        // Calculate correlation of specified and generated sequences
        /*
        List<Float> specifiedSequence = FileTools.readSequenceFromFile(fileWithSequence, 300);
        List<Float> generatedSequence = FileTools.readSequenceFromFile(fileWithGeneratedSequence, 300);
        float corr = ProbTheoryTools.calculateCorrelation(specifiedSequence, generatedSequence);
        System.out.println("Коэффициент корреляции сгенерированной и заданной последовательности: " + corr);
        */
    }

}
