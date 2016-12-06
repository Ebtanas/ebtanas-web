(ns ebtanas.handlers.public
  (:require [ebtanas.handlers.common :refer [text-html]]
            [ebtanas.views.public :as views.pub]
            [ebtanas.views.db :as views.db]))

(defn home [req]
  (text-html
    (views.pub/home
      (get-in @views.db/pages [0 :title])
      req)))

(defn koleksi-soal [req]
  (text-html
    (views.pub/koleksi-soal
      (get-in @views.db/pages [1 :title])
      req)))

(defn daftar-anggota [req]
  (text-html
    (views.pub/daftar-anggota
      (get-in @views.db/pages [2 :title])
      req)))

(defn masuk-halaman [req]
  (text-html
    (views.pub/masuk-halaman
      (get-in @views.db/pages [3 :title])
      req)))
