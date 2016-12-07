(ns ebtanas.views.db)

(def website
  (atom
    {:name "Ebtanas"
     :tagline "Practise make perfect!"
     :separator "-"}))

(defn seo-title [name]
  (interpose " " [name (@website :separator) (@website :name)]))

(def pages
  (atom
    [{:id 0 :title (@website :name)}
     {:id 1 :title (seo-title "Koleksi Soal")}
     {:id 2 :title (seo-title "Daftar Anggota")}
     {:id 3 :title (seo-title "Masuk Halaman Anggota")}
     {:id 4 :title (seo-title "Kebijakan Privasi")}
     {:id 5 :title (seo-title "Contekan")}
     {:id 6 :title (seo-title "Misi Ebtanas")}]))

;; ---------------------
;; PUBLIC DBs
;; ---------------------

(def public-header-nav
  (atom
    [{:path "/"
      :icon "icon-home"
      :title "Halaman Utama"}
     {:path "/koleksi-soal"
      :icon "icon-library_books"
      :title "Koleksi Soal"}
     {:path "/daftar"
      :icon "icon-people"
      :title "Daftar Anggota"}
     {:path "/masuk"
      :icon "icon-exit_to_app"
      :title "Masuk Halaman"}]))

(def public-footer-nav
  (atom
    [{:path "/kebijakan-privasi"
      :title "Kebijakan Privasi"}
     {:path "/contekan"
      :title "Contekan"}
     {:path "/misi-ebtanas"
      :title "Misi Ebtanas"}]))

(def copyright
  (atom
    {:symbol "&copy;"
     :date (.format
             (java.text.SimpleDateFormat. "yyyy")
             (new java.util.Date))
     :copyright "Indonesia"}))

(def front-logo
  (atom
    {:name "Logo Ebtanas"
     :img "../somewhare.png"}))

;; Dummy Data

(def matpel
  (atom
    [{:matpel "Matematika IPA"
      :chapters ["Persamaan Garis"
                 "Eksponen dan Logaritma"
                 "Persamaan Kuadrat"
                 "Fungsi Kuadrat"
                 "Pertidaksamaan"
                 "Barisan dan Derat"
                 "Trigonometri"
                 "Matriks"
                 "Program Linear"
                 "Peluang"
                 "Statistika"
                 "Limit"
                 "Turunan"
                 "Integram"
                 "Suku Banyak"
                 "Lingkaran"
                 "Vektor"
                 "Dimensi Tiga"]}
     {:matpel "Matematika IPS"
      :chapters ["Persamaan Garis"
                 "Eksponen dan Logaritma"
                 "Persamaan Kuadrat"
                 "Fungsi Kuadrat"
                 "Pertidaksamaan"
                 "Barisan dan Derat"
                 "Trigonometri"
                 "Matriks"
                 "Program Linear"
                 "Peluang"
                 "Statistika"
                 "Limit"
                 "Turunan"
                 "Integram"
                 "Suku Banyak"
                 "Lingkaran"
                 "Vektor"
                 "Dimensi Tiga"]}
     {:matpel "Bahasa Indonesia"
      :chapters ["Tata Kata"
                 "Tata Kalimat"
                 "Tata Tulis"
                 "Tata Makna"]}
     {:matpel "Bahasa Inggris"
      :chapters ["Reading"
                 "Grammer"
                 "Vocabulary"]}
     {:matpel "Fisika"
      :chapters ["Mekanika Dasar"
                 "Mekanika Lanjut"
                 "Fluida"
                 "Getaran Gelombang Bunyi"
                 "Zat dan Kalor"
                 "Listrik dan Magnet"
                 "Optika Geometri dan Fisis"
                 "Fisika Modern"]}
     {:matpel "Kimia"
      :chapters ["Atom dan Sistem Periodik"
                 "Ikatan Kimia"
                 "Stokiometri"
                 "Termokimia dan Energitika"
                 "Kecepatan Reaksi"
                 "Kesetimbangan Kimia"
                 "Sifat Koligatif"
                 "Reaksi Redoks dan Elektrokimia"
                 "Senyawa Organik"
                 "Alkana"
                 "Alkena dan Alkuna"
                 "Isomeri"
                 "Reaksi Kimia Organik"
                 "Reaksi Identifikasi"
                 "Benzena"
                 "Polimer"
                 "Radioaktif"
                 "Kimia Lingkungan"
                 "Kimia Unsur"]}
     {:matpel "Biologi"
      :chapters ["Sel"
                 "Metabolisme"
                 "Reproduksi Sel"
                 "Genetika"
                 "Mikroorganisme"
                 "Ciri dan Klasifikasi Tumbuhan"
                 "Jaringan Tumbuhan"
                 "Invertebrata"
                 "Ekologi"
                 "Evolusi"
                 "Bioteknologi"
                 "Kerja Alat Tubuh Manusia"
                 "Vertebrata"]}
     {:matpel "Ekonomi"
      :chapters ["Konsep Dasar Ekonomi"
                 "Permintaan dan Penawaran"
                 "Makroekonomi"
                 "Mikroekonomi"]}
     {:matpel "Sosiologi"
      :chapters ["Definisi dan Ciri Sosiologi"
                 "Interaksi Sosial"
                 "Sosialisasi"
                 "Nilai dan Norma"
                 "Prilaku Menyimpang"
                 "Struktur Sosial"
                 "Diferesiasi Sosial"
                 "Stratafikasi Sosial"
                 "Konflik dan Integrasi Sosial"
                 "Mobilitas Sosial"
                 "Kebudayaan"
                 "Kelompok Sosial"
                 "Perubahan Sosial"
                 "Modernisasi dan Globalisasi"
                 "Lembaga Sosial"]}
     {:matpel "Geografi"
      :chapters ["Pengindraan Jauh"
                 "Antroposfer"
                 "Atmosfer"
                 "Biosfer"
                 "Hidrosfer"
                 "Litosfer"
                 "Sumber Daya Alam"]}
     {:matpel "Sejarah"
      :chapters ["Sejaran Ilmu dan Metode"
                 "Pra Sejarah Indonesia"
                 "Jejak Sejarah"
                 "Hindu-Budha di Indonesia"
                 "Kerajaan Islam di Indonesia"
                 "Masa Kurun Niaga"
                 "Masa Kolonial VOC"
                 "Masa Kolonial Hindia Belanda"
                 "Perlawanan Terhadap Kolonial"
                 "Politik Etis dan Pergerakan Nasional"
                 "Pendudukan Jepang"
                 "Peradaban Kuno Dunia"
                 "Revolusi Barat"
                 "Nasionalisme di Asia"
                 "Perang Dunia I dan II"
                 "Perang Dingin 1947-1991"
                 "Perubahan Politik Dunia"
                 "Kemerdekaan Indonesia"
                 "Demokrasi Liberal Indonesia"
                 "Demokrasi Terpimpin Indonesia"
                 "Order Baru dan Reformasi"
                 "Organisasi Internasional"]}]))


