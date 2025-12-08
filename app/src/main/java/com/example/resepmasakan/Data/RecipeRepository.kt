package com.example.resepmasakan.data

import com.example.resepmasakan.R
import com.example.resepmasakan.Models.Kategori
import com.example.resepmasakan.Models.Resep

object RecipeRepository {

    // DATA KATEGORI
    fun getCategoryData(): List<Kategori> {
        return listOf(
            Kategori(id = 0, nama = "Semua Resep", idIcon = R.drawable.img_all_food),
            Kategori(id = 1, nama = "Nasi & Mie", idIcon = R.drawable.img_mie_dan_nasi),
            Kategori(id = 2, nama = "Daging Sapi & Kambing", idIcon = R.drawable.img_daging),
            Kategori(id = 3, nama = "Ayam", idIcon = R.drawable.img_ayam),
            Kategori(id = 4, nama = "Seafood", idIcon = R.drawable.img_seafood),
            Kategori(id = 5, nama = "Sayuran & Tumisan", idIcon = R.drawable.img_sayur)
        )
    }

    // DATA RESEP DENGAN DETAIL INSTRUKSI BARU
    // PENTING: Diubah menjadi MutableList agar status isBookmarked bisa diubah saat runtime.
    private val allRecipes: MutableList<Resep> = mutableListOf(
        Resep(
            id = 101, nama = "Nasi Goreng Spesial", idGambar = R.drawable.img_resep_nasi_goreng,
            infoDurasiPorsi = "30 Menit | 4 Porsi",
            alat = listOf("Wajan cekung (penggorengan)", "Spatula (sotil)", "Mangkuk saji", "Pisau"),
            bahan = listOf(
                "4 piring nasi putih dingin (nasi sisa semalam lebih baik)",
                "2 butir telur ayam (dikocok lepas)",
                "3 siung bawang putih (cincang halus)",
                "3 siung bawang merah (iris tipis)",
                "2 sdm kecap manis",
                "1/2 sdt merica bubuk",
                "Garam secukupnya",
                "Minyak goreng untuk menumis"
            ),
            caraMemasak = listOf(
                "Panaskan 3 sdm minyak goreng di wajan dengan api sedang cenderung besar.",
                "Masukkan telur kocok, buat orak-arik hingga matang. Sisihkan di pinggir wajan.",
                "Tambahkan sedikit minyak, masukkan bawang putih dan bawang merah. Tumis hingga harum (sekitar 1 menit).",
                "Masukkan nasi putih dingin ke dalam wajan, aduk rata dengan bumbu dan telur orak-arik.",
                "Tambahkan kecap manis, garam, dan merica bubuk. Aduk cepat dan ratakan menggunakan spatula agar warna nasi merata sempurna (proses ini penting agar nasi tidak menggumpal).",
                "Koreksi rasa. Jika sudah pas, matikan api.",
                "Sajikan nasi goreng selagi hangat. Taburi dengan bawang goreng, irisan timun, dan tomat sebagai pelengkap."
            ), rating = 4.7f, categoryId = 1, isBookmarked = false // Ditambahkan
        ),
        Resep(
            id = 109, nama = "Mie Goreng Jawa Pedas", idGambar = R.drawable.img_resep_mie_goreng,
            infoDurasiPorsi = "25 Menit | 3 Porsi",
            alat = listOf("Wajan", "Spatula", "Panci sedang", "Saringan mie"),
            bahan = listOf(
                "2 bungkus mie telor basah (atau 1 bungkus mie kering, direbus)",
                "100 gr ayam suwir (sudah direbus)",
                "1 ikat sawi hijau (potong-potong)",
                "2 sdm kecap manis",
                "Bumbu halus (Bawang merah, bawang putih, kemiri, cabai rawit)",
                "Garam, gula, dan lada secukupnya"
            ),
            caraMemasak = listOf(
                "Rebus mie telor basah sebentar (2 menit), tiriskan, beri sedikit minyak agar tidak lengket.",
                "Panaskan minyak, tumis bumbu halus hingga tercium aroma harum dan matang.",
                "Masukkan ayam suwir dan sawi, aduk hingga sawi layu.",
                "Masukkan mie yang sudah ditiriskan. Tambahkan kecap manis, garam, gula, dan lada. Aduk cepat dengan api besar.",
                "Masak selama 2-3 menit hingga bumbu meresap sempurna.",
                "Sajikan mie goreng dengan telur mata sapi dan acar timun wortel."
            ), rating = 4.5f, categoryId = 1, isBookmarked = false // Ditambahkan
        ),
        Resep(
            id = 118, nama = "Lontong Sayur Betawi", idGambar = R.drawable.img_resep_lontong_sayur,
            infoDurasiPorsi = "60 Menit | 6 Porsi",
            alat = listOf("Panci besar", "Blender/Chopper", "Wajan"),
            bahan = listOf(
                "1 kg lontong siap saji (potong-potong)",
                "500 gr labu siam (potong korek api)",
                "600 ml santan kental",
                "2 sdm ebi (udang kering), rendam air panas",
                "10 butir bawang merah, 4 siung bawang putih, 5 buah cabai merah (Bumbu halus)",
                "2 lembar daun salam",
                "Telur rebus, bawang goreng, dan kerupuk sebagai pelengkap"
            ),
            caraMemasak = listOf(
                "Tumis bumbu halus dan ebi hingga harum. Masukkan daun salam. Masak hingga matang.",
                "Masukkan labu siam, aduk rata. Masak hingga labu layu.",
                "Tuang santan, aduk perlahan-lahan (jangan sampai santan pecah). Masak hingga mendidih dan labu matang sepenuhnya.",
                "Tambahkan garam dan gula secukupnya. Koreksi rasa.",
                "Sajikan kuah sayur labu panas di atas potongan lontong. Lengkapi dengan telur rebus dan taburan kerupuk."
            ), rating = 4.4f, categoryId = 1, isBookmarked = false // Ditambahkan
        ),

        Resep(
            id = 105, nama = "Rendang Daging Sapi", idGambar = R.drawable.img_resep_rendang,
            infoDurasiPorsi = "180 Menit | 8 Porsi",
            alat = listOf("Wajan besar (untuk merandang)", "Sendok kayu (untuk mengaduk)"),
            bahan = listOf(
                "1 kg daging sapi (potong ukuran rendang)",
                "1.5 liter santan kental murni dari 2 butir kelapa",
                "2 batang serai (memarkan)",
                "5 lembar daun jeruk",
                "1 lembar daun kunyit (simpulkan)",
                "Bumbu rendang halus (cabai, bawang, jahe, lengkuas, kunyit, ketumbar)"
            ),
            caraMemasak = listOf(
                "Campurkan santan, bumbu halus, serai, daun jeruk, dan daun kunyit dalam wajan besar.",
                "Masak campuran santan sambil terus diaduk perlahan hingga mengental dan mengeluarkan minyak.",
                "Masukkan potongan daging sapi. Aduk rata agar daging terlumuri bumbu.",
                "Kecilkan api ke level sangat kecil. Masak terus (proses merandang) selama minimal 2-3 jam.",
                "Aduk sesekali. Masak hingga santan mengering, bumbu meresap sempurna, dan rendang berwarna cokelat kehitaman.",
                "Koreksi rasa. Rendang siap disajikan."
            ), rating = 4.9f, categoryId = 2, isBookmarked = false // Ditambahkan
        ),
        Resep(
            id = 110, nama = "Tongseng Sapi Khas Solo", idGambar = R.drawable.img_resep_tongseng,
            infoDurasiPorsi = "75 Menit | 6 Porsi",
            alat = listOf("Panci presto (opsional)", "Wajan"),
            bahan = listOf(
                "500 gr daging sapi (potong dadu kecil)",
                "1/4 buah kol (iris kasar)",
                "2 buah tomat (potong-potong)",
                "300 ml santan encer",
                "4 sdm kecap manis",
                "Garam, lada, air secukupnya",
                "Bumbu tongseng halus (bawang, cabai, jahe, kunyit)"
            ),
            caraMemasak = listOf(
                "Rebus daging sapi hingga empuk (gunakan panci presto 15 menit). Sisihkan kaldu rebusan.",
                "Panaskan minyak di wajan, tumis bumbu tongseng hingga matang dan harum. Masukkan daging, aduk hingga berubah warna.",
                "Tuang santan encer dan air kaldu, masak hingga mendidih dan kuah sedikit berkurang.",
                "Tambahkan kecap manis, garam, dan lada. Koreksi rasa.",
                "Masukkan kol dan tomat menjelang diangkat (masak sebentar saja agar sayuran tetap renyah).",
                "Sajikan tongseng sapi selagi panas dengan taburan bawang goreng."
            ), rating = 4.3f, categoryId = 2, isBookmarked = false // Ditambahkan
        ),
        Resep(
            id = 116, nama = "Sate Kambing Bumbu Kecap", idGambar = R.drawable.img_resep_sate_kambing,
            infoDurasiPorsi = "60 Menit | 15 Tusuk",
            alat = listOf("Tusuk sate", "Panggangan arang/gas"),
            bahan = listOf(
                "500 gr daging kambing (potong dadu 2x2 cm)",
                "1/2 buah nanas muda (parut)",
                "Bumbu oles (kecap manis, minyak, bawang merah iris, merica)",
                "Sambal kecap (cabai rawit, bawang merah, tomat, kecap manis)"
            ),
            caraMemasak = listOf(
                "Potong daging kambing, lumuri dengan nanas parut selama maksimal 10 menit (jangan lebih lama agar daging tidak hancur). Setelah itu bilas.",
                "Tusuk daging di tusuk sate. Lumuri dengan bumbu olesan kecap.",
                "Bakar sate di atas panggangan sambil terus dibolak-balik.",
                "Selama proses membakar, olesi sate dengan bumbu olesan berulang kali hingga matang merata dan bumbu meresap.",
                "Sajikan sate kambing hangat bersama sambal kecap dan acar mentimun."
            ), rating = 4.6f, categoryId = 2, isBookmarked = false // Ditambahkan
        ),

        Resep(
            id = 102, nama = "Soto Ayam Kuah Kuning", idGambar = R.drawable.img_resep_soto,
            infoDurasiPorsi = "45 Menit | 6 Porsi",
            alat = listOf("Panci besar", "Blender/Ulekan", "Wajan"),
            bahan = listOf(
                "1/2 kg ayam (dada atau paha)",
                "2 liter air kaldu",
                "Bumbu halus soto (bawang merah, bawang putih, kunyit, jahe, kemiri)",
                "1 batang serai (memarkan)",
                "3 lembar daun jeruk",
                "Pelengkap: Tauge, mie soun, telur rebus, seledri, bawang goreng"
            ),
            caraMemasak = listOf(
                "Rebus ayam hingga mendidih dan matang. Angkat ayam, saring kaldu (sisihkan).",
                "Tumis bumbu halus soto bersama serai dan daun jeruk hingga harum dan matang sempurna.",
                "Masukkan tumisan bumbu ke dalam air kaldu, masak hingga mendidih kembali.",
                "Tambahkan garam dan gula. Koreksi rasa. Goreng ayam yang sudah direbus lalu suwir-suwir.",
                "Sajikan soto dengan menata mie soun, tauge, dan suwiran ayam di mangkuk. Siram dengan kuah panas. Taburi daun seledri dan bawang goreng."
            ), rating = 4.5f, categoryId = 3, isBookmarked = false // Ditambahkan
        ),
        Resep(
            id = 113, nama = "Ayam Goreng Lengkuas", idGambar = R.drawable.img_resep_ayam_lengkuas,
            infoDurasiPorsi = "50 Menit | 4 Potong",
            alat = listOf("Panci presto (opsional)", "Wajan", "Saringan minyak"),
            bahan = listOf(
                "1 ekor ayam (potong 4 bagian)",
                "Air kelapa (secukupnya untuk mengungkep)",
                "Bumbu halus (bawang, kunyit, ketumbar)",
                "300 gr lengkuas parut (banyak dibutuhkan untuk serundeng)"
            ),
            caraMemasak = listOf(
                "Campurkan ayam, bumbu halus, dan sebagian lengkuas parut. Tambahkan air kelapa hingga ayam terendam.",
                "Ungkep ayam dengan api kecil hingga air menyusut dan bumbu meresap sempurna (sekitar 30-40 menit).",
                "Angkat ayam, sisihkan sisa bumbu dan lengkuas.",
                "Goreng ayam dalam minyak panas hingga berwarna kuning kecoklatan. Angkat.",
                "Goreng sisa bumbu lengkuas dalam minyak sisa penggorengan hingga kering dan renyah (serundeng lengkuas).",
                "Sajikan ayam goreng dengan taburan serundeng lengkuas yang garing."
            ), rating = 4.8f, categoryId = 3, isBookmarked = false // Ditambahkan
        ),
        Resep(
            id = 119, nama = "Ayam Bakar Bumbu Rujak", idGambar = R.drawable.img_resep_ayam_rujak,
            infoDurasiPorsi = "60 Menit | 4 Potong",
            alat = listOf("Panci", "Panggangan arang/gas"),
            bahan = listOf(
                "1 ekor ayam (potong 4)",
                "300 ml santan kental",
                "1 sdm asam jawa (larutkan)",
                "2 sdm gula merah",
                "Bumbu halus pedas (cabai, bawang, tomat)"
            ),
            caraMemasak = listOf(
                "Ungkep ayam bersama santan, bumbu halus, asam jawa, dan gula merah. Aduk rata.",
                "Masak dengan api sedang hingga air menyusut, bumbu mengental (menjadi bumbu olesan), dan ayam matang.",
                "Angkat ayam. Sisihkan bumbu kental yang tersisa.",
                "Bakar ayam di atas panggangan sambil diolesi sisa bumbu berulang kali hingga ayam berwarna kecoklatan dan siap disajikan."
            ), rating = 4.5f, categoryId = 3, isBookmarked = false // Ditambahkan
        ),

        Resep(
            id = 107, nama = "Cumi Saus Padang Pedas", idGambar = R.drawable.img_resep_cumi,
            infoDurasiPorsi = "25 Menit | 3 Porsi",
            alat = listOf("Wajan besar", "Pisau"),
            bahan = listOf(
                "300 gr cumi segar (bersihkan, potong melingkar)",
                "2 sdm saus sambal",
                "1 sdm saus tomat",
                "1/2 buah bawang bombay (iris)",
                "Bumbu halus (bawang, cabai, jahe)"
            ),
            caraMemasak = listOf(
                "Cuci bersih cumi. Panaskan minyak, tumis bumbu halus hingga harum. Masukkan bawang bombay.",
                "Masukkan saus sambal, saus tomat, dan sedikit air. Didihkan.",
                "Masukkan cumi. Masak dengan api besar **selama 2-3 menit saja**.",
                "Koreksi rasa. Segera angkat cumi setelah matang (memasak terlalu lama akan membuat cumi alot).",
                "Sajikan hangat dengan nasi."
            ), rating = 4.6f, categoryId = 4, isBookmarked = false // Ditambahkan
        ),
        Resep(
            id = 114, nama = "Ikan Bakar Bumbu Kuning", idGambar = R.drawable.img_resep_ikan_bakar,
            infoDurasiPorsi = "45 Menit | 2 Porsi",
            alat = listOf("Panggangan/Teflon", "Sikat oles"),
            bahan = listOf(
                "2 ekor ikan nila/gurame (bersihkan, kerat-kerat)",
                "Bumbu halus kuning (kunyit, bawang merah, bawang putih, jahe)",
                "2 sdm kecap manis",
                "Air jeruk nipis"
            ),
            caraMemasak = listOf(
                "Bersihkan ikan, kerat-kerat bagian badan. Lumuri dengan air jeruk nipis, diamkan 10 menit.",
                "Campurkan bumbu halus kuning, kecap manis, dan sedikit minyak. Aduk rata.",
                "Lumuri seluruh permukaan ikan dengan bumbu hingga merata, diamkan 15 menit agar meresap.",
                "Bakar ikan di atas panggangan/teflon. Bolak-balik sambil terus diolesi sisa bumbu hingga matang merata dan harum.",
                "Sajikan ikan bakar dengan sambal dabu-dabu atau sambal terasi dan lalapan."
            ), rating = 4.7f, categoryId = 4, isBookmarked = false // Ditambahkan
        ),
        Resep(
            id = 120, nama = "Udang Goreng Saus Mentega", idGambar = R.drawable.img_resep_udang_mentega,
            infoDurasiPorsi = "20 Menit | 4 Porsi",
            alat = listOf("Wajan"),
            bahan = listOf(
                "500 gr udang segar (bersihkan)",
                "5 sdm mentega/margarin",
                "4 siung bawang putih (geprek)",
                "2 sdm kecap inggris",
                "1 sdm saus tiram",
                "Garam & lada"
            ),
            caraMemasak = listOf(
                "Bersihkan udang. Panaskan mentega hingga meleleh. Tumis bawang putih geprek hingga harum.",
                "Masukkan udang. Masak hingga udang berubah warna menjadi kemerahan.",
                "Tambahkan kecap inggris dan saus tiram. Aduk cepat.",
                "Tambahkan sedikit air jika terlalu kering, garam, dan lada. Masak hingga saus mengental dan udang matang.",
                "Koreksi rasa dan segera sajikan hangat."
            ), rating = 4.4f, categoryId = 4, isBookmarked = false // Ditambahkan
        ),

        Resep(
            id = 104, nama = "Capcay Sayur Kuah", idGambar = R.drawable.img_resep_capcay,
            infoDurasiPorsi = "20 Menit | 3 Porsi",
            alat = listOf("Wajan", "Pisau", "Panci sedang"),
            bahan = listOf(
                "1 ikat sawi hijau",
                "1 buah wortel (iris serong)",
                "100 gr kembang kol",
                "3 siung bawang putih (geprek)",
                "1 sdm saus tiram",
                "Garam, gula, lada, air secukupnya",
                "1 sdm tepung maizena (larutkan)"
            ),
            caraMemasak = listOf(
                "Siapkan semua sayuran dan potong-potong.",
                "Panaskan 2 sdm minyak. Tumis bawang putih hingga harum. Masukkan wortel dan kembang kol, tumis sebentar. Tambahkan sedikit air.",
                "Setelah wortel setengah empuk, masukkan sawi hijau dan saus tiram.",
                "Tambahkan garam, gula, dan lada. Aduk cepat.",
                "Tuang larutan maizena untuk mengentalkan kuah. Masak hingga semua sayuran matang tetapi masih renyah (sekitar 2 menit).",
                "Koreksi rasa, sajikan."
            ), rating = 3.9f, categoryId = 5, isBookmarked = false // Ditambahkan
        ),
        Resep(
            id = 111, nama = "Sayur Asem Jakarta", idGambar = R.drawable.img_resep_sayur_asem,
            infoDurasiPorsi = "40 Menit | 8 Porsi",
            alat = listOf("Panci besar"),
            bahan = listOf(
                "1 buah jagung manis (potong-potong)",
                "1 ikat kacang panjang",
                "1 buah labu siam",
                "1/2 ikat daun melinjo",
                "Asam jawa (secukupnya)",
                "Bumbu halus (bawang, cabai, kemiri, terasi)"
            ),
            caraMemasak = listOf(
                "Didihkan air dalam panci besar. Masukkan bumbu halus dan asam jawa.",
                "Masukkan sayuran keras terlebih dahulu (jagung, labu siam). Masak hingga setengah empuk.",
                "Masukkan sayuran lunak (kacang panjang, daun melinjo). Tambahkan garam dan gula.",
                "Masak hingga semua sayuran matang. Koreksi rasa (rasa harus segar asam, manis, dan sedikit pedas).",
                "Sajikan sayur asem hangat dengan ikan asin dan sambal terasi."
            ), rating = 4.1f, categoryId = 5, isBookmarked = false // Ditambahkan
        ),
        Resep(
            id = 115, nama = "Tumis Kangkung Terasi", idGambar = R.drawable.img_resep_kangkung,
            infoDurasiPorsi = "15 Menit | 2 Porsi",
            alat = listOf("Wajan"),
            bahan = listOf(
                "1 ikat kangkung segar (siangi daunnya)",
                "3 siung bawang merah (iris)",
                "2 siung bawang putih (iris)",
                "1/2 sdt terasi (bakar/goreng sebentar)",
                "5 buah cabai rawit (sesuai selera)",
                "Garam, gula, dan sedikit air"
            ),
            caraMemasak = listOf(
                "Siapkan kangkung, potong dan cuci bersih. Tiriskan.",
                "Panaskan minyak dengan api besar. Tumis semua bumbu iris dan terasi hingga harum.",
                "Masukkan kangkung. Aduk cepat dengan api besar.",
                "Tambahkan garam, gula, dan sedikit air. Masak hanya 1-2 menit hingga kangkung layu tetapi masih renyah dan berwarna hijau cerah.",
                "Koreksi rasa dan segera angkat. Sajikan agar kangkung tidak layu."
            ), rating = 3.8f, categoryId = 5, isBookmarked = false // Ditambahkan
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
        // Mengambil 6 resep terbaik berdasarkan rating
        return allRecipes.sortedByDescending { it.rating }.take(6)
    }

    fun getFavoriteResep(): List<Resep> {
        // Mengambil 5 resep dengan rating tinggi (misalnya >= 4.7)
        // Note: Anda mungkin ingin memfilter berdasarkan 'isBookmarked == true' untuk Favorite sejati.
        return allRecipes.filter { it.rating >= 4.7f }.take(5)
    }

    fun findRecipeById(id: Int): Resep? {
        return allRecipes.find { it.id == id }
    }

    // --- FUNGSI BARU WAJIB UNTUK BOOKMARKING ---
    /**
     * Mengupdate status isBookmarked pada objek Resep di dalam Repository.
     * Ini menyelesaikan error 'Unresolved reference' dari RecipeDetailActivity.
     */
    fun updateRecipeBookmarkStatus(recipeId: Int, newStatus: Boolean) {
        val recipe = allRecipes.find { it.id == recipeId }
        // Mengubah status isBookmarked. Ini berhasil karena allRecipes adalah MutableList
        recipe?.isBookmarked = newStatus
    }
}