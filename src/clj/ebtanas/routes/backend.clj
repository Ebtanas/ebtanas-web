(ns ebtanas.routes.backend
  (:require [compojure.core :refer [defroutes GET POST]]))

(defroutes backend-routes
  (POST "/panel" req (str "<h1>" req "</h1>")))
