(ns ebtanas.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [routes]]
            [ebtanas.routes.public :refer [public]]))

(def all-routes (routes public))

(defn -main [& [port]]
  (jetty/run-jetty
    (-> #'all-routes
        (wrap-reload))
    {:port (if port (Integer. port) 3000)
     :join false}))
