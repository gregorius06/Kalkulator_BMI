package model;

/** Klasifikasi BMI untuk populasi Asia-Pasifik. */
public class BmiAsiaPasifik extends Bmi {

    public BmiAsiaPasifik(String nama, double beratKg, double tinggiCm) {
        super(nama, beratKg, tinggiCm);
    }

    @Override
    public String getNamaStandar() {
        return "Asia-Pasifik";
    }

    @Override
    public String getKategori() {
        double bmi = hitungBmi();
        if (bmi < 18.5) return "Berat badan kurang";
        if (bmi < 23.0) return "Normal";
        if (bmi < 25.0) return "Berisiko berlebih";
        if (bmi < 30.0) return "Obesitas I";
        return "Obesitas II";
    }
}
