(ns ebtanas.handlers.common
  (:require [ring.util.http-response :as response]))

(defn wrap-text-html-ok [view]
  (assoc
    (response/ok view)
    :headers {"Content-Type" "text/html"}))

