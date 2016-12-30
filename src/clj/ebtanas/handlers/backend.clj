(ns ebtanas.handlers.backend
  (:require [ebtanas.handlers.common :as handle.c]
            [ebtanas.handlers.auth :refer [register!]]
            [ebtanas.views.backend :as views.back]))

(defn registration-response [req]
  (let [{:keys [body] :as res} (register! req (req :params))]
    (handle.c/wrap-text-html-ok
      (views.back/registration-response (body :message) res req))))
