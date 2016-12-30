(ns ebtanas.views.backend
  (:require ;[ebtanas.views.common :as common :refer [layout]]
            [ebtanas.views.public :refer [document]]))

(defn registration-response
  [title res & [req]]
  (document title req
    (condp = (get-in res [:body :response-code])
      1 [:h3 "Pengguna dengan email yang dimasukan sudah pernah daftar sebelumnya, silahkan "
         [:a {:href "/masuk"} "masuk"] "!"]
      2 [:h3 "Server error saat ini (ns. auth 2)! hubungi admin@ebtanas.id!"]
      3 [:h3 "Tolong periksa lagi masukan, masukan belum valid! "
         [:a {:href "/daftar"} "kembali"] "."]
      4 [:h3 "Registrasi Sukses! Silahkan " [:a {:href "/masuk"} "login"] "."]
      [:h3 "(ns. auth unknown)! please contact admin@ebtanas.id"])))