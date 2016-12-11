(ns ebtanas.routes.public
  (:require [compojure.core :refer [defroutes GET]]
            [ebtanas.handlers.public :as handle.pub]
            [ebtanas.db.static-queries :refer [get-pub-path]]))

(defroutes public-routes
  (GET (get-pub-path 0) [] handle.pub/home)
  (GET (get-pub-path 1) [] handle.pub/koleksi-soal)
  (GET (get-pub-path 2) [] handle.pub/daftar-anggota)
  (GET (get-pub-path 3) [] handle.pub/masuk-halaman)
  (GET "/page/:id" [id] "Under Construction!"))

