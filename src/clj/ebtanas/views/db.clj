(ns ebtanas.views.db)

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
      :title "Masuk"}]))

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

(def matpel
  (atom
    ["Matematika"
     "B. Indonesia"
     "B. Inggris"
     "Fisika"
     "Kumia"
     "Biologi"
     "Geografi"
     "Sejarah"
     "Ekonomi"
     "Sosiologi"]))