(ns ebtanas.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.gzip :refer [wrap-gzip]]
            [ring.middleware.webjars :refer [wrap-webjars]]
            [compojure.core :refer [routes]]
            [compojure.route :refer [resources not-found]]
            [ebtanas.routes.public :refer [public-routes]]
            [ebtanas.routes.backend :refer [backend-routes]]))

(def all-routes
  (routes
    (resources "/")
    public-routes
    backend-routes
    (not-found "<h1>404</h1>")))

(defonce server
  (fn [& [port]]
    (jetty/run-jetty
      (-> #'all-routes
          (wrap-reload)
          (wrap-webjars)
          (wrap-defaults site-defaults)
          (wrap-gzip))
      {:port (if port (Integer. port) 3000)
       :join false})))

(defn -main [& [port]]
  (server port))