(ns ebtanas.handlers.public
  (:require [ebtanas.handlers.common :refer [text-html]]
            [ebtanas.views.public :as views.pub]))

(defn home [req]
  (text-html (views.pub/home "Ebtanas" req)))

(defn koleksi-soal [req]
  (text-html (views.pub/koleksi-soal "Koleksi Soal" req)))

