(ns ebtanas.handlers.public
  (:require [ebtanas.handlers.common :as handle.c]
            [ebtanas.views.public :as views.pub]
            [ebtanas.db.static.queries :refer [get-page-title get-items] :as atm]))

(defn home [req]
  (handle.c/wrap-text-html-ok
    (views.pub/home (get-page-title 0) req)))

(defn koleksi-soal [req]
  (handle.c/wrap-text-html-ok
    (views.pub/koleksi-soal (get-page-title 1) req)))

(defn daftar-anggota [req]
  (handle.c/wrap-text-html-ok
    (views.pub/daftar-anggota (get-page-title 2) req)))

(defn masuk-halaman [req]
  (handle.c/wrap-text-html-ok
    (views.pub/masuk-halaman (get-page-title 3) req)))

(defn document [req]
  (let [path (str "/" (get-in req [:params :path]))]
    (if (some #(= path %) (atm/get-pub-footer-nav-paths))
      (handle.c/wrap-text-html-ok
        (views.pub/document
          (condp = path
            "/kebijakan-privasi" (get-page-title 4)
            "/contekan" (get-page-title 5)
            "/misi-ebtanas" (get-page-title 6))
          req))
      (handle.c/wrap-text-html-404 "<h1>Not Found 404</h1>"))))
