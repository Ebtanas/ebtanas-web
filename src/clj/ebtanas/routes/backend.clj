(ns ebtanas.routes.backend
  (:require [compojure.core :refer [defroutes GET POST]]
            [ebtanas.handlers.backend :as handle.back]))

(defroutes backend-routes
  (POST "/registration-response" req (handle.back/registration-response req)))
