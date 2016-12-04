(ns ebtanas.routes.public
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [ebtanas.handlers.public :refer [home]]))

(defroutes public
  (GET "/" [] home)
  (not-found "<h1>404</h1>"))
