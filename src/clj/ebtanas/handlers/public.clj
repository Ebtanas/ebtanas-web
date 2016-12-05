(ns ebtanas.handlers.public
  (:require [ring.util.http-response :as response]
            [ebtanas.views.public :as vpub]))

(defn home [req]
  (response/ok (vpub/home "Ebtanas" req)))
