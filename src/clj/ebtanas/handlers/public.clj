(ns ebtanas.handlers.public
  (:require [ring.util.http-response :as response]))

(defn home [req]
  (response/ok "<h1>Hello, Clojure World</h1>"))
