package com.example.maizedotco;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Diagnosa extends AppCompatActivity {

    Spinner spinner1;
    Spinner spinner2;
    TextView selection;
    TextView hasilDiagnosis;

    String[] item1 = {"Daun", "Batang", "Pelepah"};
    String[] item2 = {"Tanaman terlihat kerdil", "Terdapat garis-garis berwarna agak kekuningan (khlorotik) memanjang sejajar tulang daun", "Bunga jantan berubah menjadi massa daun yang berlebihan", "Daun-daun menggulung", "Tongkol tidak terbentuk", "Terdapat serbuk seperti tepung di permukaan bawah daun",
            "Bercak berwarna cokelat atau merah orangnye seperti karat pada permukaan daun atas dan bawah", "Bercak kecil berbentuk oval pada daun", "Daun layu dan kering", "Bercak bewarna cokelat kemerahan berbentuk kumparan dengan pinggiran bercak bewarna hijau kuning atau khlorotik pada permukaan daun", "Biji rusak dan busuk", "Tongkol gugur", "Bercak di seluruh bagian tanaman seperti daun, pelepah, batang, tangkai kelobot, bulir dan tongkol", "Hawar berwarna abu-abu seperti terbakar atau mengering", "Bercak memanjang berbentuk ellips", "Bercak kering yang luas (hawar) berwarna hijau keabu-abuan atau cokelat", "Daun berwarna mosaik atau hijau", "Bagian dalam batang busuk dan mudah rebah", "Pangkal batang berwarna kecoklatan", "Bagian kulit luar tipis", "Bercak jamur bewarna agak kemerahan menjadi abu-abu pudar pada permukaan pelepah", "Bercak meluas dan terpisah pisah seperti gejala panu", "Pembentukan gumpalan keraskeras (sklerotia) yang tidak beraturan berwarna putih hingga cokelat gelap", "Bagian dalam biji berwarna gelap dan menjadi massa tepung berwarna cokelat gelap sampai hitam", "Bengkakan besar pada biji-biji tongkol"};

    public static void RefreshList() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diagnosa_penyakit);

        selection = findViewById(R.id.selection);
        hasilDiagnosis = findViewById(R.id.hasilDiagnosis);

        // Spinner pertama
        spinner1 = findViewById(R.id.spinner);
        ArrayAdapter<String> aa1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, item1);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(aa1);

        // Spinner kedua
        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> aa2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, item2);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner2.setAdapter(aa2);

        // Button Diagnosis
        Button diagnosisButton = findViewById(R.id.diagnosis);
        diagnosisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView();
            }
        });

        // Menambahkan listener untuk Spinner pertama
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                updateTextView();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Tidak perlu melakukan apa-apa jika tidak ada yang dipilih
            }
        });

        // Menambahkan listener untuk Spinner kedua
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                updateTextView();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Tidak perlu melakukan apa-apa jika tidak ada yang dipilih
            }
        });
    }

    private void updateTextView() {
        String selectedPart = spinner1.getSelectedItem().toString();
        String selectedSymptom = spinner2.getSelectedItem().toString();

        // Menentukan penyakit berdasarkan pilihan
        String disease = "";

        if (selectedPart.equals("Daun")) {
            if (selectedSymptom.equals("Tanaman terlihat kerdil") || selectedSymptom.equals("Terdapat garis-garis berwarna agak kekuningan (khlorotik) memanjang sejajar tulang daun") ||
                    selectedSymptom.equals("Bunga jantan berubah menjadi massa daun yang berlebihan") || selectedSymptom.equals("Daun-daun menggulung") ||
                    selectedSymptom.equals("Tongkol tidak terbentuk") || selectedSymptom.equals("Terdapat serbuk seperti tepung di permukaan bawah daun")) {
                disease = "Penyakit Bulai";
            } else if (selectedSymptom.equals("Bercak berwarna cokelat atau merah orangnye seperti karat pada permukaan daun atas dan bawah") ||
                    selectedSymptom.equals("Bercak kecil berbentuk oval pada daun") || selectedSymptom.equals("Daun layu dan kering")) {
                disease = "Penyakit Karat Daun";
            } else if (selectedSymptom.equals("Bercak bewarna cokelat kemerahan berbentuk kumparan dengan pinggiran bercak bewarna hijau kuning atau khlorotik pada permukaan daun") ||
                    selectedSymptom.equals("Biji rusak dan busuk") || selectedSymptom.equals("Tongkol gugur") ||
                    selectedSymptom.equals("Bercak di seluruh bagian tanaman seperti daun, pelepah, batang, tangkai kelobot, bulir dan tongkol")) {
                disease = "Penyakit Bercak Daun";
            } else if (selectedSymptom.equals("Hawar berwarna abu-abu seperti terbakar atau mengering") ||
                    selectedSymptom.equals("Bercak memanjang berbentuk ellips") || selectedSymptom.equals("Bercak kering yang luas (hawar) berwarna hijau keabu-abuan atau cokelat")) {
                disease = "Penyakit Hawar Daun";
            } else if (selectedSymptom.equals("Daun berwarna mosaik atau hijau")) {
                disease = "Penyakit Mosaik Jagung";
            }
        } else if (selectedPart.equals("Batang")) {
            if (selectedSymptom.equals("Bagian dalam batang busuk dan mudah rebah") ||
                    selectedSymptom.equals("Pangkal batang berwarna kecoklatan") || selectedSymptom.equals("Bagian kulit luar tipis")) {
                disease = "Penyakit Busuk Batang";
            }
        } else if (selectedPart.equals("Pelepah")) {
            if (selectedSymptom.equals("Bercak jamur bewarna agak kemerahan menjadi abu-abu pudar pada permukaan pelepah") ||
                    selectedSymptom.equals("Bercak meluas dan terpisah pisah seperti gejala panu") || selectedSymptom.equals("Pembentukan gumpalan keraskeras (sklerotia) yang tidak beraturan berwarna putih hingga cokelat gelap")) {
                disease = "Penyakit Busuk Pelepah";
            } else if (selectedSymptom.equals("Bagian dalam biji berwarna gelap dan menjadi massa tepung berwarna cokelat gelap sampai hitam") ||
                    selectedSymptom.equals("Bengkakan besar pada biji-biji tongkol")) {
                disease = "Gosong";
            }
        }

        // Menampilkan hasil di TextView
        hasilDiagnosis.setText(disease);
    }
}