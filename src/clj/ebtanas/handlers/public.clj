(ns ebtanas.handlers.public
  (:require [ebtanas.handlers.common :refer [wrap-text-html-ok]]
            [ebtanas.views.public :as views.pub]
            [ebtanas.db.static-queries :refer [get-title]]))

(defn home [req]
  (wrap-text-html-ok
    (views.pub/home (get-title 0) req)))

(defn koleksi-soal [req]
  (wrap-text-html-ok
    (views.pub/koleksi-soal (get-title 1) req)))

(defn daftar-anggota [req]
  (wrap-text-html-ok
    (views.pub/daftar-anggota (get-title 2) req)))

(defn masuk-halaman [req]
  (wrap-text-html-ok
    (views.pub/masuk-halaman (get-title 3) req)))
