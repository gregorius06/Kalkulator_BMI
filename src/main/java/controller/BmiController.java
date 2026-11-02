package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.MainApp;
import model.Bmi;
import model.BmiAsiaPasifik;
import model.BmiWHO;

import java.net.URL;
import java.util.ResourceBundle;

public class BmiController implements Initializable {

    private static final String WHO = "WHO";
    private static final String ASIA = "Asia-Pasifik";

    @FXML private TextField txtNama;
    @FXML private ComboBox<String> cbStandar;
    @FXML private TextField txtBerat;
    @FXML private TextField txtTinggi;
    @FXML private Label lblHasil;
    @FXML private Label lblKategori;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbStandar.getItems().addAll(WHO, ASIA);
        cbStandar.getSelectionModel().selectFirst();
    }

    @FXML
    private void handleHitung() {
        String nama = txtNama.getText();
        String standar = cbStandar.getValue();

        if (nama == null || nama.trim().isEmpty() || standar == null) {
            tampilError("Nama dan standar BMI wajib diisi.");
            return;
        }

        double berat;
        double tinggi;
        try {
            berat = Double.parseDouble(txtBerat.getText().trim().replace(',', '.'));
            tinggi = Double.parseDouble(txtTinggi.getText().trim().replace(',', '.'));
        } catch (NumberFormatException ex) {
            tampilError("Berat dan tinggi harus berupa angka.");
            return;
        }

        try {
            Bmi bmi;
            if (ASIA.equals(standar)) {
                bmi = new BmiAsiaPasifik(nama, berat, tinggi);
            } else {
                bmi = new BmiWHO(nama, berat, tinggi);
            }

            lblHasil.setText(String.format("%s, BMI kamu: %.1f", bmi.getNama(), bmi.hitungBmi()));
            lblKategori.setText("Kategori (" + bmi.getNamaStandar() + "): " + bmi.getKategori());
            lblKategori.setStyle("-fx-text-fill: " + warna(bmi.getKategori()) + ";");
        } catch (IllegalArgumentException ex) {
            tampilError(ex.getMessage());
        }
    }

    @FXML
    private void handleReset() {
        txtNama.clear();
        cbStandar.getSelectionModel().selectFirst();
        txtBerat.clear();
        txtTinggi.clear();
        lblHasil.setText("");
        lblKategori.setText("");
    }

    @FXML
    private void handleKembali() {
        MainApp.tampilkanHome();
    }

    private void tampilError(String pesan) {
        lblHasil.setText("");
        lblKategori.setText(pesan);
        lblKategori.setStyle("-fx-text-fill: #dc2626;");
    }

    private String warna(String kategori) {
        if (kategori.equals("Normal")) return "#16a34a";
        if (kategori.startsWith("Obesitas")) return "#dc2626";
        return "#d97706";
    }
}
