(ns ebtanas.routes.backend
  (:require [compojure.core :refer [defroutes GET POST]]
            [ebtanas.handlers.auth :refer [register!]]
            [ebtanas.handlers.backend :as handle.back]))

(defroutes backend-routes
  (POST "/registration-response" req (register! req (req :params))))
  ;(POST "/registration-response" req (handle.back/registration-response (req :params))))