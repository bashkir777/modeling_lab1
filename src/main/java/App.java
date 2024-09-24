import chart.ChartTools;
import generator.Generator;
import tools.FileTools;
import tools.ProbTheoryTools;

import java.io.IOException;
import java.util.List;

import static chart.ChartTools.showDiagramWithBins;


public class App {

    public static void main( String[] args ) throws IOException {

//        System.out.println(ProbTheoryTools.relativeDeviation(standard, 51.67f));
//        System.out.println(ProbTheoryTools.relativeDeviation(standard, 45.51f));
//        System.out.println(ProbTheoryTools.relativeDeviation(standard,49.76f ));
//        System.out.println(ProbTheoryTools.relativeDeviation(standard, 43.02f));
          String fileWithSequence = args[0];
          String fileWithGeneratedSequence = args[1];

          //List<Float> sequence1 = FileTools.readSequenceFromFile(fileWithSequence, 300);
          List<Float> sequence = FileTools.readSequenceFromFile(fileWithGeneratedSequence, 300);

//          System.out.println(ProbTheoryTools.getConfidentialInterval(sequence, 0.9f));
//          System.out.println(ProbTheoryTools.getConfidentialInterval(sequence, 0.95f));
//          System.out.println(ProbTheoryTools.getConfidentialInterval(sequence, 0.99f));
//        System.out.println("Математическое ожидание: " + ProbTheoryTools.mathematicalExpectation(sequence));
//        System.out.println("Дисперсия: " + ProbTheoryTools.dispersion(sequence));
//        System.out.println("Средне квадратическое отклонение: " + ProbTheoryTools.standardDeviation(sequence));
//        System.out.println("Коэфициент вариации: " + ProbTheoryTools.coefficientVariation(sequence) + "%");

//        List<Float> sequence = Generator.generateErlangRandomNumbers(4, 0.0154, 1, 1000, 300);
//        FileTools.writeSequenceToFile(sequence, args[1]);

//        List<Float> res = ProbTheoryTools.calculateAutoCorrelation(sequence, 10);
//
//        for(float val: res){
//            System.out.println(val);
//        }
//
//        ChartTools.showChart(res, "Автокорреляция для заданной числовой последовательности", "Лаг", "Коэффициент автокорреляции");
         //ChartTools.showChart(sequence, "График последовательности", "Индекс", "Значение");
        List<Float> density = ProbTheoryTools.computeErlangDensity(ProbTheoryTools.generateIntegerList(30, 800), 4,0.0154);

        ChartTools.showChart(density, "График функции плотности", "x", "f(x)", 30);

         //showDiagramWithBins(ChartTools.splitToIntervalsAndCountFrequency(sequence, 10), "Гистограмма распределения частот", "Интервалы", "Частоты");
        //showHistogramWithErlangDensity(sequence,10, 4,0.0154, "Гистограмма распределения частот", "Интервалы", "Частоты");
//        float corr = ProbTheoryTools.calculateCorrelation(sequence1, sequence2);
//        System.out.println("Коэффициент корреляции сгенерированной и заданной последовательности: " + corr);
    }



}
