package com.example.maizedotco;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivityPenyakit extends AppCompatActivity {

    Button btn_kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penyakit);

        btn_kembali = findViewById(R.id.btn_kembali);

        // Dapatkan data dari Intent
        String namaPenyakit = getIntent().getStringExtra("nama_penyakit");

        // Tampilkan data pada TextView atau elemen UI lainnya
        TextView textViewNamaPenyakit = findViewById(R.id.textViewNamaPenyakit);
        TextView textViewDeskripsi = findViewById(R.id.textViewDeskripsi);
        TextView textViewSolusi = findViewById(R.id.textViewSolusi);
        ImageView imageViewPenyakit = findViewById(R.id.imageViewPenyakit);
        TextView penjelasan2 = findViewById(R.id.textViewPenjelasanSolusi);
        TextView penjelasan = findViewById(R.id.textViewPenjelasanDeskripsi);

        // Set nama penyakit
        textViewNamaPenyakit.setText(namaPenyakit);

        // Tentukan sumber gambar berdasarkan nama penyakit
        String namaGambar = namaPenyakit.toLowerCase().replace(" ", "_");
        int gambarResourceId = getResources().getIdentifier(namaGambar, "drawable", getPackageName());

        // Set gambar pada ImageView
        if (gambarResourceId != 0) {
            imageViewPenyakit.setImageResource(gambarResourceId);
        } else {
            // Gambar default jika tidak ditemukan
            imageViewPenyakit.setImageResource(R.drawable.bulai_jagung);
        }

        // Log untuk memeriksa apakah data terkirim dengan benar
        Log.d("DetailActivityPenyakit", "Nama Penyakit: " + namaPenyakit);
        Log.d("DetailActivityPenyakit", "ID Gambar: " + gambarResourceId);

        // Simulasi data deskripsi dan solusi penyakit (gantilah dengan data sebenarnya)
        String deskripsiPenyakit = "Deskripsi Penyakit " + namaPenyakit;
        String solusiPenyakit = "Solusi Penanganan Penyakit " + namaPenyakit;
        String Penyakit = "Penyakit " + namaPenyakit;

        // Set deskripsi dan solusi penyakit
        textViewDeskripsi.setText(deskripsiPenyakit);
        textViewSolusi.setText(solusiPenyakit);
        textViewNamaPenyakit.setText(Penyakit);

        if(namaPenyakit.equals("Bulai")) {
            String deskripsi = "Bulai merupakan penyakit yang disebabkan oleh jamur Peronosclerospora maydis maupun Peronosclerospora philippinensis. Jamur P. maydis ditemukan di seluruh wilayah Indonesia, sedangkan P. philippinensis ditemukan di Sulawesi Utara, Filipina, Taiwan, Muangthai, dan India.\\n Gejala yang terdapat pada tanaman yang terinfeksi penyakit ini yaitu pada permukaan daun terdapat garis-garis sejajar tulang daun berwarna putih sampai kuning diikuti dengan garis-garis khlorotik sampai coklat bila infeksi makin lanjut. Kerugian hasil panen yang ditimbulkan oleh penyakit ini dapat mencapai 100%." ;
            penjelasan.setText(deskripsi);
            String solusi = "a. Tanam varietas jagung yang tahan bulai seperti Kalingga, Arjuna, Wiyasa, Bromo, Parikesit, dan Hibrida Cl.\n" +
                    "b. Tidak menanam benih jagung yang berasal dari tanaman sakit.\n" +
                    "c. Tanam jagung secara serempak pada awal sampai akhir musim kemarau. Penanaman jagung pada peralihan musim (marengan atau labuhan) akan menderita kerugian besar karena bulai.\n" +
                    "d. Perlakuan benih dengan fungisida sistemik seperti Ridomil 35 SD (5 g formulasi/kg benih Ridomil mengandung bahan aktif metalaksil 35%)";
            penjelasan2.setText(solusi);
        } else if (namaPenyakit.equals("Karat Daun")) {
            String deskripsi = "Karat daun merupakan penyakit yang disebabkan oleh jamur Puccinia polysora. Karat ini ditemukan pada dataran rendah sampai dataran tinggi (1200 m) dan ditemukan pada musim hujan sampai kemarau. Gejala yang terdapat pada tanaman untuk penyakit ini adalah pada permukaan daun atas dan bawah terdapat bercak-bercak kecil (uredinia), bulat sampai oval, berwarna coklat atau merah oranye, panjang 0,2-2 mm. Daerah sebaran penyakit antara lain Amerika, Afrika, Australia, Asia Selatan dan Asia Tenggara.";
            penjelasan.setText(deskripsi);
            String solusi = "a. Tanam varietas tahan seperti Kalingga, Arjuna, Wiyasa, Pioneer-2. Hibrida Cl sangat peka terhadap penyakit ini. \n" +
                    "b. Gunakan fungisida triadomefon atau golongan dithiokarbamat secara semprotan.\n";
            penjelasan2.setText(solusi);
        } else if (namaPenyakit.equals("Bercak Daun")) {
            String deskripsi = "Bercak daun pada jagung disebabkan oleh jamur Helminthosporium maydis. Ada dua tipe bercak: ras 0 (bercak sejajar pada daun, tidak signifikan pada jagung normal) dan ras T (virulen terhadap jagung jantan mandul, bisa menyebabkan kematian bibit dan kerugian hasil hingga 90%). Penyakit ini tersebar global, berdampak signifikan di daerah hangat (20-32°C) dan lembab.";
            penjelasan.setText(deskripsi);
            String solusi = "a. Gunakan varietas tahan. \n" +
                    "b. Pembajakan tanah yang bersih dapat mengurangi infeksi. \n" +
                    "c. Hindari menanam jagung terlalu rapat. \n" +
                    "d. Gunakan fungisida sistemik, terutama sejak bunga jantan muncul dengan interval 7-10 hari. \n" +
                    "e. Hindari menanam jagung yang bersitoplasma jantan mandul. \n";
            penjelasan2.setText(solusi);
        } else if (namaPenyakit.equals("Hawar Daun")) {
            String deskripsi = "Hawar daun merupakan penyakit yang disebabkan oleh jamur Helminthosporium turcicum. Jamur H. turcicum bertahan hidup sampai satu tahun berupa miselium dorman dalam daun, kelobot, atau bagian tanaman lainnya pada sisa-sisa tanaman di lapang. Perkembangan penyakit sangat baik pada suhu udara antara 18-27°C dan udara berembun. Kerugian hasil panen dapat mencapai 70% jika terserang penyakit bercak daun";
            penjelasan.setText(deskripsi);
            String solusi = "a. Tanam varietas tahan seperti Kalingga, Arjuna, dan Hibrida Cl. Varietas jagung manis (sweet corn) sangat peka terhadap penyakit ini. \n" +
                    "b. Tanam jagung pada awal sampai akhir kemarau dan secara serempak. \n" +
                    "c. Gunakan fungisida sistemik secara semprotan. \n" ;
            penjelasan2.setText(solusi);
        } else if (namaPenyakit.equals("Busuk Pelepah")) {
            String deskripsi = "Busuk pelepah merupakan penyakit yang disebabkan oleh jamur Rhizoctonia zeae. Gejala awal dari penyakit ini tampak pada permukaan pelepah bercak jamur berwarna salmon, kemudian berubah jadi abu-abu pudar. Bercak meluas dan terpisah-pisah seperti gejala panu dan sering diikuti pembentukan sklerotia dengan bentuk tidak beraturan, berkesan seperti cipratan tanah, berwarna putih,salmon sampai coklat gelap. Varietas jagung dengan pelepah daun yang rapat sampai ke tanah paling mudah terinfeksi.";
            penjelasan.setText(deskripsi);
            String solusi = "a. Tanam varietas tahan. \n" +
                    "b. Pilih varietas dengan pelepah berkurang di bawah batang untuk menghindari perkembangan penyakit.  \n" +
                    "c. Sebaiknya menanam jagung pada awal musim kemarau. \n" ;
            penjelasan2.setText(solusi);
        } else if (namaPenyakit.equals("Busuk Batang")) {
            String deskripsi = "Busuk batang merupakan penyakit yang disebabkan oleh jamur busuk batang seperti Diplodia maydis, Gibberella roseum f.sp. cerealis, Fusarium moniliforme. Keadaan cuaca kering pada saat tanam jagung dengan suhu hangat (28-30°C) dan udara basah pada 2-3 minggu setelah pembentukan bulu jagung sangat baik bagi perkembangan busuk batang. Kandungan nitrogen dan kalium rendah, populasi tanaman tinggi (sangat rapat), kerusakan karena hujan deras dan serangga dapat melemahkan tanaman jagung terhadap infeksi. Daerah sebaran penyakit busuk batang mencakup seluruh dunia dan kerugian hasil panen akibat penyakit dapat mencapai 40% pada musim hujan.";
            penjelasan.setText(deskripsi);
            String solusi = "a. Tanam varietas tahan diplodia dan varietas tahan dengan tongkol tertutup sempurna. \n" +
                    "b. Jaga kesuburan tanah yang berimbang.  \n" +
                    "c. Atur populasi tanaman agar jangan terlalu rapat. \n" +
                    "d. Hindari penanaman pada musim penghujan..  \n" +
                    "e. Lakukan sanitasi dan rotasi.  \n" +
                    "f. Gunakan fungisida efektif secara semprotan.  \n" +
                    "g. Tanam benih sehat (kadar air 14 %).. \n" ;
            penjelasan2.setText(solusi);
        } else if (namaPenyakit.equals("Gosong")) {
            String deskripsi = "Gosong merupakan penyakit yang disebabkan oleh jamur Ustilago maydis. Perkembangan penyakit gosong sangat baik pada keadaan kering dengan suhu 26-34°C. Ciri penyakit tampak jelas bengkakan besar pada biji-biji tongkol ditutupi jaringan kehijauan, putih sampai putih perak dan berkilau. Kerugian hasil panen diperkirakan mencapai 15% akibat penyakit gosong.";
            penjelasan.setText(deskripsi);
            String solusi = "a. Tanam varietas tahan. \n" +
                    "b. Buang dan bakar bagian yang terinfeksi sebelum bengkakan pecah..  \n" +
                    "c. Jaga kesuburan tanah yang berimbang. \n" ;
            penjelasan2.setText(solusi);
        } else if (namaPenyakit.equals("Mosaik Jagung")) {
            String deskripsi = "Penyakit mosaik jagung adalah penyakit yang disebabkan oleh virus mosaik jagung melalui serangga loncat. Sebaran penyakit mosaik jagung meliputi Amerika, Australia, Asia Tenggara, dan Afrika. Gejala mosaik jagung ini sering dikacaukan dengan gejala penyakit bulai. Ciri khas dari penyakit ini yaitu daun berwarna mosaik..";
            penjelasan.setText(deskripsi);
            String solusi = "a. Tanam varietas tahan, seperti galur murn. \n" +
                    "b. Lakukan penyiangan dua kali \n" ;
            penjelasan2.setText(solusi);
        }


        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}