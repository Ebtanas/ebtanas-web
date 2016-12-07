(ns ebtanas.routes.public
  (:require [compojure.core :refer [defroutes GET]]
            [ebtanas.handlers.public :as handle.pub]
            [ebtanas.views.db :as views.db]))

(defroutes public-routes
  (GET (get-in @views.db/public-header-nav [0 :path])
       [] handle.pub/home)
  (GET (get-in @views.db/public-header-nav [1 :path])
       [] handle.pub/koleksi-soal)
  (GET (get-in @views.db/public-header-nav [2 :path])
       [] handle.pub/daftar-anggota)
  (GET (get-in @views.db/public-header-nav [3 :path])
       [] handle.pub/masuk-halaman)
  (GET "/page/:id" [id] "Under Construction!"))

