package model;

/** Klasifikasi BMI standar WHO untuk dewasa. */
public class BmiWHO extends Bmi {

    public BmiWHO(String nama, double beratKg, double tinggiCm) {
        super(nama, beratKg, tinggiCm);
    }

    @Override
    public String getNamaStandar() {
        return "WHO";
    }

    @Override
    public String getKategori() {
        double bmi = hitungBmi();
        if (bmi < 18.5) return "Berat badan kurang";
        if (bmi < 25.0) return "Normal";
        if (bmi < 30.0) return "Berat badan berlebih";
        return "Obesitas";
    }
}
