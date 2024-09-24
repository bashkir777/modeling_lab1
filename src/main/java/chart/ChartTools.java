package chart;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.util.*;

public class ChartTools {

    private static CategoryChart createCategoryChartSample(String title, String xAxisTitle, String yAxisTitle){
        CategoryChart chart = new CategoryChartBuilder()
                .title(title)
                .xAxisTitle(xAxisTitle)
                .yAxisTitle(yAxisTitle)
                .width(800)
                .height(600)
                .build();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setAvailableSpaceFill(0.95);
        chart.getStyler().setOverlapped(false);
        return chart;
    }
    private static XYChart createXYChartSample(String title, String xAxisTitle, String yAxisTitle) {
        XYChart chart = new XYChartBuilder()
                .title(title)
                .xAxisTitle(xAxisTitle)
                .yAxisTitle(yAxisTitle)
                .width(800)
                .height(600)
                .build();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        return chart;
    }

    public static LinkedHashMap<String, Integer> splitToIntervalsAndCountFrequency(List<? extends Number> sequence, int intervalsCount) {
        sequence.sort(Comparator.comparingDouble(Number::doubleValue));

        double min = sequence.get(0).doubleValue();
        double max = sequence.get(sequence.size() - 1).doubleValue();
        double h = (max - min) / intervalsCount;

        LinkedHashMap<String, Integer> frequencies = new LinkedHashMap<>();

        for (int i = 0; i < intervalsCount; i++) {
            double start = min + i * h;
            double end = start + h;
            String interval = String.format("%.2f - %.2f", start, end);
            frequencies.put(interval, 0);
        }

        for (Number num : sequence) {
            double value = num.doubleValue();
            for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
                String interval = entry.getKey();
                String[] bounds = interval.split(" - ");
                double start = Double.parseDouble(bounds[0]);
                double end = Double.parseDouble(bounds[1]);
                if (value >= start && value < end) {
                    frequencies.put(interval, entry.getValue() + 1);
                    break;
                }
            }
        }

        return frequencies;
    }

    public static void showDiagramWithBins(LinkedHashMap<String, Integer> intervalToFrequencies, String title, String xAxisTitle, String yAxisTitle) {

        CategoryChart chart = createCategoryChartSample(title, xAxisTitle, yAxisTitle);

        chart.addSeries("Частоты", new ArrayList<>(intervalToFrequencies.keySet()),
                new ArrayList<>(intervalToFrequencies.values()));

        new SwingWrapper<>(chart).displayChart();
    }

    public static void showChart(List<? extends Number> sequence, String title, String xAxisTitle, String yAxisTitle, int startIndex) {
        XYChart chart = createXYChartSample(title, xAxisTitle, yAxisTitle);

        List<Integer> indices = new ArrayList<>();
        for (int i = startIndex; i < sequence.size() + startIndex; i++) {
            indices.add(i);
        }

        chart.addSeries("Последовательность", indices, sequence);

        new SwingWrapper<>(chart).displayChart();
    }

}

