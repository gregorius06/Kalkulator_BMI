package main;

import model.Bmi;
import model.BmiAsiaPasifik;
import model.BmiWHO;

/** Demo model tanpa GUI (jalan di terminal / Output NetBeans). */
public class DemoTerminalMode {

    public static void main(String[] args) {
        Bmi[] daftar = {
            new BmiWHO("Andi", 60, 170),
            new BmiAsiaPasifik("Andi", 60, 170),
            new BmiWHO("Budi", 85, 165),
            new BmiAsiaPasifik("Budi", 85, 165),
            new BmiWHO("Citra", 45, 160)
        };

        for (Bmi b : daftar) {
            System.out.println(b);
        }
    }
}
