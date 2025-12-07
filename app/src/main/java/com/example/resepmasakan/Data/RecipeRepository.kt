package com.example.resepmasakan.data

import com.example.resepmasakan.R
import com.example.resepmasakan.Models.Kategori
import com.example.resepmasakan.Models.Resep

object RecipeRepository {

    // FUNGSI 1: DATA KATEGORI
    fun getCategoryData(): List<Kategori> {
        return listOf(
            Kategori(id = 0, nama = "Semua Resep", idIcon = R.drawable.img_all_food),
            Kategori(id = 1, nama = "Nasi & Mie", idIcon = R.drawable.img_mie_dan_nasi),
            Kategori(id = 2, nama = "Daging Sapi & Kambing", idIcon = R.drawable.img_daging),
            Kategori(id = 3, nama = "Ayam", idIcon = R.drawable.img_ayam),
            Kategori(id = 4, nama = "Makanan Laut (Seafood)", idIcon = R.drawable.img_seafood),
            Kategori(id = 5, nama = "Sayuran & Tumisan", idIcon = R.drawable.img_sayur)
        )
    }

    // FUNGSI 2: DATA RESEP DENGAN KATEGORI SEIMBANG (Total 15 Resep)
    private val allRecipes: List<Resep> = listOf(
        // --- KATEGORI 1: Nasi & Mie (3 Resep) ---
        Resep(
            id = 101, nama = "Nasi Goreng Spesial", idGambar = R.drawable.img_resep_nasi_goreng,
            infoDurasiPorsi = "30 Menit | 4 Porsi", alat = listOf("Wajan", "Spatula", "Mangkuk"),
            bahan = listOf("4 piring nasi putih dingin", "2 butir telur", "3 siung bawang putih (cincang)", "2 sdm kecap manis", "Garam & merica secukupnya"),
            caraMemasak = listOf(
                "Panaskan 3 sdm minyak di wajan dengan api sedang.", "Masukkan telur, orak-arik hingga matang. Sisihkan di pinggir wajan.",
                "Masukkan bawang putih cincang, tumis hingga harum (sekitar 30 detik).", "Masukkan nasi putih dingin, aduk rata dengan bumbu dan telur.",
                "Tambahkan kecap manis, garam, dan merica. Aduk cepat hingga warna nasi merata sempurna.",
                "Koreksi rasa, sajikan selagi hangat dengan taburan bawang goreng."
            ), rating = 4.7f, categoryId = 1
        ),
        Resep(
            id = 109, nama = "Mie Goreng Jawa Pedas", idGambar = R.drawable.img_resep_mie_goreng,
            infoDurasiPorsi = "25 Menit | 3 Porsi", alat = listOf("Wajan", "Spatula"),
            bahan = listOf("2 bungkus mie telor basah", "Ayam suwir", "Sawi hijau", "Bumbu halus"),
            caraMemasak = listOf(
                "Rebus mie telor sebentar, tiriskan.", "Panaskan minyak, tumis bumbu halus hingga harum.",
                "Masukkan ayam suwir dan sawi, aduk hingga layu.",
                "Masukkan mie, tambahkan kecap manis, garam, dan merica. Aduk cepat.",
                "Sajikan dengan telur mata sapi dan acar."
            ), rating = 4.5f, categoryId = 1
        ),
        Resep(
            id = 118, nama = "Lontong Sayur Betawi", idGambar = R.drawable.img_resep_lontong_sayur,
            infoDurasiPorsi = "60 Menit | 6 Porsi", alat = listOf("Panci besar", "Blender"),
            bahan = listOf("1 kg lontong siap saji", "Labu siam (potong korek)", "Santan", "Ebi", "Bumbu halus (cabai, bawang, kunyit)", "Telur rebus"),
            caraMemasak = listOf(
                "Tumis bumbu halus dan ebi hingga harum. Masukkan labu siam, masak hingga layu.",
                "Tuang santan, aduk perlahan agar santan tidak pecah. Masak hingga mendidih dan labu matang.",
                "Tambahkan garam dan gula. Koreksi rasa.",
                "Sajikan sayur labu panas di atas potongan lontong. Lengkapi dengan telur rebus dan kerupuk."
            ), rating = 4.4f, categoryId = 1
        ),

        // --- KATEGORI 2: Daging Sapi & Kambing (3 Resep) ---
        Resep(
            id = 105, nama = "Rendang Daging Sapi", idGambar = R.drawable.img_resep_rendang,
            infoDurasiPorsi = "180 Menit | 8 Porsi", alat = listOf("Wajan besar", "Sendok kayu"),
            bahan = listOf("1 kg daging sapi (potong rendang)", "1 liter santan kental", "2 batang serai", "5 lembar daun jeruk", "Bumbu rendang halus"),
            caraMemasak = listOf(
                "Campurkan santan, bumbu halus, serai, dan daun jeruk. Masak sambil terus diaduk hingga mengental.",
                "Masukkan potongan daging sapi. Aduk rata.",
                "Kecilkan api. Masak terus selama 2-3 jam sambil sesekali diaduk (proses merandang).",
                "Masak hingga santan mengering, bumbu meresap sempurna, dan rendang berubah warna menjadi cokelat kehitaman."
            ), rating = 4.9f, categoryId = 2
        ),
        Resep(
            id = 110, nama = "Tongseng Sapi Khas Solo", idGambar = R.drawable.img_resep_tongseng,
            infoDurasiPorsi = "75 Menit | 6 Porsi", alat = listOf("Panci", "Wajan"),
            bahan = listOf("500 gr daging sapi (potong dadu)", "Kol", "Tomat", "Santan encer", "Kecap manis"),
            caraMemasak = listOf(
                "Rebus daging hingga empuk. Sisihkan kaldu.", "Tumis bumbu tongseng hingga matang. Masukkan daging, aduk.",
                "Tuang santan encer dan kaldu, masak hingga mendidih.",
                "Tambahkan kecap manis, garam, dan lada. Masukkan kol dan tomat menjelang diangkat."
            ), rating = 4.3f, categoryId = 2
        ),
        Resep(
            id = 116, nama = "Sate Kambing Bumbu Kecap", idGambar = R.drawable.img_resep_sate_kambing,
            infoDurasiPorsi = "60 Menit | 15 Tusuk", alat = listOf("Tusuk sate", "Panggangan"),
            bahan = listOf("500 gr daging kambing", "Bumbu oles (kecap, bawang merah iris, merica)", "Nanas parut (untuk melunakkan)"),
            caraMemasak = listOf(
                "Potong daging kambing kotak-kotak, lumuri nanas parut (10 menit), lalu bilas.",
                "Tusuk daging di tusuk sate. Lumuri dengan bumbu olesan kecap.",
                "Bakar di atas panggangan sambil diolesi bumbu berulang kali hingga matang merata."
            ), rating = 4.6f, categoryId = 2
        ),

        // --- KATEGORI 3: Ayam (3 Resep) ---
        Resep(
            id = 102, nama = "Soto Ayam Kuah Kuning", idGambar = R.drawable.img_resep_soto,
            infoDurasiPorsi = "45 Menit | 6 Porsi", alat = listOf("Panci besar", "Blender/Ulekan", "Wajan"),
            bahan = listOf("1/2 kg ayam (dada atau paha)", "2 liter air", "1 bungkus bumbu instan soto", "1 batang serai (memarkan)", "Daun jeruk, garam, gula secukupnya"),
            caraMemasak = listOf(
                "Rebus ayam dalam 2 liter air hingga mendidih. Angkat ayam, saring kaldu.", "Tumis bumbu soto bersama serai dan daun jeruk hingga harum. Masukkan tumisan bumbu ke dalam kaldu.",
                "Tambahkan garam dan gula. Goreng ayam yang sudah direbus lalu suwir-suwir.",
                "Sajikan soto dengan suwiran ayam, tauge, daun seledri, dan perasan jeruk nipis."
            ), rating = 4.5f, categoryId = 3
        ),
        Resep(
            id = 113, nama = "Ayam Goreng Lengkuas", idGambar = R.drawable.img_resep_ayam_lengkuas,
            infoDurasiPorsi = "50 Menit | 4 Potong", alat = listOf("Panci presto (opsional)", "Wajan"),
            bahan = listOf("1 ekor ayam (potong 4)", "Bumbu halus (bawang, kunyit, ketumbar)", "Lengkuas parut banyak", "Air kelapa"),
            caraMemasak = listOf(
                "Campurkan ayam, bumbu halus, dan lengkuas parut. Tambahkan air kelapa hingga ayam terendam.",
                "Ungkep ayam dengan api kecil hingga air menyusut dan bumbu meresap sempurna.",
                "Angkat ayam, sisihkan bumbu lengkuas.",
                "Goreng ayam dalam minyak panas hingga kecoklatan. Goreng sisa bumbu lengkuas hingga kering dan renyah.",
                "Sajikan ayam goreng dengan taburan bumbu lengkuas."
            ), rating = 4.8f, categoryId = 3
        ),
        Resep(
            id = 119, nama = "Ayam Bakar Bumbu Rujak", idGambar = R.drawable.img_resep_ayam_rujak,
            infoDurasiPorsi = "60 Menit | 4 Potong", alat = listOf("Panci", "Panggangan"),
            bahan = listOf("1 ekor ayam (potong 4)", "Santan kental", "Asam jawa", "Gula merah", "Bumbu halus pedas"),
            caraMemasak = listOf(
                "Ungkep ayam bersama santan, bumbu halus, asam jawa, dan gula merah hingga air menyusut dan bumbu mengental.",
                "Angkat ayam. Sisa bumbu digunakan sebagai olesan.",
                "Bakar ayam di atas panggangan sambil diolesi sisa bumbu hingga berwarna kecoklatan dan matang."
            ), rating = 4.5f, categoryId = 3
        ),

        // --- KATEGORI 4: Makanan Laut (3 Resep) ---
        Resep(
            id = 107, nama = "Cumi Saus Padang Pedas", idGambar = R.drawable.img_resep_cumi,
            infoDurasiPorsi = "25 Menit | 3 Porsi", alat = listOf("Wajan besar"),
            bahan = listOf("300 gr cumi segar", "2 sdm saus sambal", "1 sdm saus tomat", "Bawang bombay (iris)", "Bumbu halus"),
            caraMemasak = listOf(
                "Cuci bersih cumi, potong melingkar.", "Panaskan minyak, tumis bumbu halus hingga harum. Masukkan bawang bombay.",
                "Masukkan saus sambal, saus tomat, dan sedikit air. Didihkan.",
                "Masukkan cumi. Masak dengan api besar selama 2-3 menit saja. Jangan memasak cumi terlalu lama agar tidak alot."
            ), rating = 4.6f, categoryId = 4
        ),
        Resep(
            id = 114, nama = "Ikan Bakar Bumbu Kuning", idGambar = R.drawable.img_resep_ikan_bakar,
            infoDurasiPorsi = "45 Menit | 2 Porsi", alat = listOf("Panggangan/Teflon"),
            bahan = listOf("2 ekor ikan nila/gurame", "Bumbu halus kuning (kunyit, bawang)", "Kecap manis", "Air jeruk nipis"),
            caraMemasak = listOf(
                "Bersihkan ikan, kerat-kerat bagian badan. Lumuri dengan air jeruk nipis.",
                "Campurkan bumbu halus kuning dengan sedikit kecap manis.",
                "Lumuri seluruh permukaan ikan dengan bumbu hingga merata, diamkan 15 menit.",
                "Bakar ikan di atas panggangan/teflon sambil terus diolesi sisa bumbu hingga matang merata dan harum.",
                "Sajikan dengan sambal dabu-dabu atau sambal terasi."
            ), rating = 4.7f, categoryId = 4
        ),
        Resep(
            id = 120, nama = "Udang Goreng Saus Mentega", idGambar = R.drawable.img_resep_udang_mentega,
            infoDurasiPorsi = "20 Menit | 4 Porsi", alat = listOf("Wajan"),
            bahan = listOf("500 gr udang segar", "5 sdm mentega", "4 siung bawang putih (geprek)", "2 sdm kecap inggris", "Garam & lada"),
            caraMemasak = listOf(
                "Bersihkan udang dan buang kepala. Lumuri dengan sedikit garam dan lada.",
                "Panaskan mentega hingga meleleh. Tumis bawang putih geprek hingga harum.",
                "Masukkan udang, masak hingga berubah warna menjadi kemerahan.",
                "Tambahkan kecap inggris dan sedikit air. Aduk cepat hingga saus mengental dan udang matang.",
                "Koreksi rasa dan sajikan hangat."
            ), rating = 4.4f, categoryId = 4
        ),

        // --- KATEGORI 5: Sayuran & Tumisan (3 Resep) ---
        Resep(
            id = 104, nama = "Capcay Sayur Kuah", idGambar = R.drawable.img_resep_capcay,
            infoDurasiPorsi = "20 Menit | 3 Porsi", alat = listOf("Wajan", "Pisau"),
            bahan = listOf("1 ikat sawi hijau", "1 buah wortel (iris)", "100 gr kembang kol", "3 siung bawang putih (geprek)", "Garam, gula, lada, air secukupnya"),
            caraMemasak = listOf(
                "Siapkan semua sayuran dan potong-potong.", "Panaskan 2 sdm minyak. Tumis bawang putih hingga harum.",
                "Masukkan wortel dan kembang kol, tumis sebentar. Tambahkan sedikit air.",
                "Masukkan sawi hijau. Tambahkan garam, gula, dan lada. Aduk cepat.",
                "Masak hingga semua sayuran matang, tetapi masih renyah. Koreksi rasa dan sajikan."
            ), rating = 3.9f, categoryId = 5
        ),
        Resep(
            id = 111, nama = "Sayur Asem Jakarta", idGambar = R.drawable.img_resep_sayur_asem,
            infoDurasiPorsi = "40 Menit | 8 Porsi", alat = listOf("Panci besar"),
            bahan = listOf("Jagung manis", "Kacang panjang", "Labu siam", "Daun melinjo", "Asam jawa, bumbu halus"),
            caraMemasak = listOf(
                "Didihkan air. Masukkan bumbu halus dan asam jawa.",
                "Masukkan sayuran keras (jagung, melinjo). Masak hingga setengah empuk.",
                "Masukkan sayuran lunak (kacang panjang, labu siam). Tambahkan garam dan gula.",
                "Masak hingga semua matang. Koreksi rasa."
            ), rating = 4.1f, categoryId = 5
        ),
        Resep(
            id = 115, nama = "Tumis Kangkung Terasi", idGambar = R.drawable.img_resep_kangkung,
            infoDurasiPorsi = "15 Menit | 2 Porsi", alat = listOf("Wajan"),
            bahan = listOf("1 ikat kangkung segar", "3 siung bawang merah (iris)", "2 siung bawang putih (iris)", "Terasi secukupnya", "Cabai rawit (sesuai selera)"),
            caraMemasak = listOf(
                "Siapkan kangkung, potong dan cuci bersih.", "Panaskan minyak, tumis semua bumbu iris dan terasi hingga harum.",
                "Besarkan api, masukkan kangkung. Aduk cepat.",
                "Tambahkan garam, gula, dan sedikit air. Masak hanya 1-2 menit hingga kangkung layu. Koreksi rasa dan segera angkat."
            ), rating = 3.8f, categoryId = 5
        )
    )

    // FUNGSI PENTING: Mengambil Resep, dengan Filter Kategori Opsional.
    fun getRecipesByCategory(categoryId: Int? = null): List<Resep> {
        return if (categoryId == 0 || categoryId == null) {
            allRecipes
        } else {
            allRecipes.filter { it.categoryId == categoryId }
        }
    }

    // FUNGSI LAINNYA
    fun getRecommendationData(): List<Resep> {
        return allRecipes.sortedByDescending { it.rating }.take(6)
    }

    fun getFavoriteResep(): List<Resep> {
        return allRecipes.filter { it.rating >= 4.7f }.take(5)
    }

    fun findRecipeById(id: Int): Resep? {
        return allRecipes.find { it.id == id }
    }
}