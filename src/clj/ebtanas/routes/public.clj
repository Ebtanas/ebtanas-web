(ns ebtanas.routes.public
  (:require [compojure.core :refer [defroutes GET]]
            [ebtanas.handlers.public :as handle.pub]
            [ebtanas.db.static.queries :refer [get-pub-header-nav-path]]))

(defroutes public-routes
  (GET (get-pub-header-nav-path 0) req (handle.pub/home req))
  (GET (get-pub-header-nav-path 1) req (handle.pub/koleksi-soal req))
  (GET (get-pub-header-nav-path 2) req (handle.pub/daftar-anggota req))
  (GET (get-pub-header-nav-path 3) req (handle.pub/masuk-halaman req))
  (GET "/page/:path" req (handle.pub/document req)))