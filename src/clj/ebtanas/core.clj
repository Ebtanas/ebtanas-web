(ns ebtanas.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults api-defaults]]
            [ring.middleware.reload :refer [wrap-reload]]
            ;[ring.middleware.params :refer [wrap-params]]
            ;[ring.middleware.format :refer [wrap-restful-format]]
            [ring.middleware.gzip :refer [wrap-gzip]]
            [ring.middleware.webjars :refer [wrap-webjars]]
            [compojure.core :refer [routes]]
            [compojure.route :refer [resources not-found]]
            [ebtanas.routes.public :refer [public-routes]]
            [ebtanas.routes.backend :refer [backend-routes]]
            [ebtanas.routes.services :refer [service-route]]))

(def all-routes
  (routes
    (resources "/")
    public-routes
    backend-routes
    service-route
    (not-found "<h1>404</h1>")))

(defonce server
  (fn [& [port]]
    (jetty/run-jetty
      (-> #'all-routes
          (wrap-reload)
          (wrap-webjars)
          ;(wrap-params)
          ;(wrap-defaults site-defaults) ;;site-defaults)
          (wrap-defaults (assoc-in site-defaults [:security :anti-forgery] false))
          (wrap-gzip))
      {:port (if port (Integer. port) 3000)
       :join false})))

(defn -main [& [port]]
  (server port))