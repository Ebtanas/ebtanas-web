(ns ebtanas.routes.public
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [ebtanas.handlers.public :as handle.pub]))

(defroutes public
  (GET "/" [] handle.pub/home))