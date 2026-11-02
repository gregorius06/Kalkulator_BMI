package model;

/**
 * Kelas abstrak untuk perhitungan BMI.
 * Subclass menentukan standar kategori yang dipakai (polimorfisme).
 */
public abstract class Bmi {

    private final String nama;
    private final double beratKg;
    private final double tinggiCm;

    protected Bmi(String nama, double beratKg, double tinggiCm) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong.");
        }
        if (beratKg <= 0 || tinggiCm <= 0) {
            throw new IllegalArgumentException("Berat dan tinggi harus lebih dari 0.");
        }
        this.nama = nama.trim();
        this.beratKg = beratKg;
        this.tinggiCm = tinggiCm;
    }

    public String getNama() {
        return nama;
    }

    public double getBeratKg() {
        return beratKg;
    }

    public double getTinggiCm() {
        return tinggiCm;
    }

    /** BMI = berat (kg) / (tinggi (m))^2 */
    public double hitungBmi() {
        double tinggiM = tinggiCm / 100.0;
        return beratKg / (tinggiM * tinggiM);
    }

    /** Nama standar klasifikasi, mis. "WHO". */
    public abstract String getNamaStandar();

    /** Kategori BMI sesuai standar subclass. */
    public abstract String getKategori();

    @Override
    public String toString() {
        return String.format("%s | BMI %.1f | %s (%s)", nama, hitungBmi(), getKategori(), getNamaStandar());
    }
}
