(ns ebtanas.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [routes]]
            [compojure.route :refer [resources not-found]]
            [ebtanas.routes.public :refer [public]]))

(def all-routes
  (routes
    (resources "/")
    public
    (not-found "<h1>404</h1>")))

(defn -main [& [port]]
  (jetty/run-jetty
    (-> #'all-routes
        (wrap-reload))
    {:port (if port (Integer. port) 3000)
     :join false}))
