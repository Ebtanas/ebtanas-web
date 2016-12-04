(ns ebtanas.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.util.http-response :as response]
            [ring.middleware.reload :refer [wrap-reload]]))

(defn handler [req]
  (response/ok "Hello World from Ring"))

(defn -main [& [port]]
  (jetty/run-jetty
    (-> #'handler
        (wrap-reload))
    {:port (if port (Integer. port) 3000)
     :join false}))

