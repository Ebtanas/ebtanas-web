(ns ebtanas.routes.public
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [ebtanas.handlers.public :as handle.pub]
            [ebtanas.views.db :as views.db]))

(defroutes public
  (GET
    (get-in @views.db/public-header-nav [0 :path])
    [] handle.pub/home)
  (GET
    (get-in @views.db/public-header-nav [1 :path])
    [] handle.pub/koleksi-soal))
