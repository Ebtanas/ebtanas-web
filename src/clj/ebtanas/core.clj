(ns ebtanas.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [routes]]
            [compojure.route :refer [resources not-found]]
            [ebtanas.routes.public :refer [public]]))

(def all-routes
  (routes
    (resources "/")
    public
    (not-found "<h1>404</h1>")))

(defn server [& [port]]
  (jetty/run-jetty
    (-> #'all-routes
        (wrap-reload)
        (wrap-defaults site-defaults))
    {:port (if port (Integer. port) 3000)
     :join false}))

(defn -main [& [port]]
  (server port))
