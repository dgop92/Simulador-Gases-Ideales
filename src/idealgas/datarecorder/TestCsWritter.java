package idealgas.datarecorder;

import java.util.HashMap;


public class TestCsWritter {

    public static void main(String[] args) {

        HashMap<String, Float> gasData;
        gasData = new HashMap<>();

        gasData.put("pressure", 60000f);
        gasData.put("volume", 93.5f);
        gasData.put("temperature", 300f);

        gasData.put("work", 60005.4f);
        gasData.put("heat", -93115f);
        gasData.put("internalEnergy", 10050f);

        gasData.put("velocity", 540f);

        long start = System.nanoTime();
        CSVWritter sCsvWritter = new CSVWritter();
        for (int i = 0; i < 5; i++) {
            sCsvWritter.putRow(gasData);
        }
        long end = System.nanoTime();
        System.out.println(end - start);

        /* System.out.println(String.format("%.2f", 93.513f)); */

        start = System.nanoTime();
        System.out.println(sCsvWritter.saveData());
        end = System.nanoTime();
        System.out.println(end - start);
    }
}
