package tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTools {

    public static List<Float> readSequenceFromFile(String fileName, int amount) throws IOException {
        List<Float> sequence = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null && counter < amount) {
                sequence.add(Float.parseFloat(line.replace(',', '.')));
                counter++;
            }
        }
        return sequence;
    }

    public static void writeSequenceToFile(List<Float> sequence, String fileName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (float num : sequence) {
                float roundedNum = Math.round(num * 1000) / 1000.0f;
                bw.write(Float.toString(roundedNum) + '\n');
            }
            bw.flush();
        }
    }
}
