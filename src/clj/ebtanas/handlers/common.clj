(ns ebtanas.handlers.common
  (:require [ring.util.http-response :as response]))

(defn text-html [view]
  (assoc
    (response/ok view)
    :headers {"Content-Type" "text/html"}))

