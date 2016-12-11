(ns ebtanas.handlers.public
  (:require [ebtanas.handlers.common :refer [wrap-text-html-ok
                                             wrap-text-html-404]]
            [ebtanas.views.public :as views.pub]
            [ebtanas.db.static-queries :refer [get-page-title get-items] :as atm]))

(defn home [req]
  (wrap-text-html-ok
    (views.pub/home (get-page-title 0) req)))

(defn koleksi-soal [req]
  (wrap-text-html-ok
    (views.pub/koleksi-soal (get-page-title 1) req)))

(defn daftar-anggota [req]
  (wrap-text-html-ok
    (views.pub/daftar-anggota (get-page-title 2) req)))

(defn masuk-halaman [req]
  (wrap-text-html-ok
    (views.pub/masuk-halaman (get-page-title 3) req)))

(defn document [req]
  (let [path (str "/" (get-in req [:params :path]))]
    (if (some #(= path %) (atm/get-pub-footer-nav-paths))
      (wrap-text-html-ok
        (views.pub/document "Hello" req))
      (wrap-text-html-404 "<h1>Not Found 404</h1>"))))
