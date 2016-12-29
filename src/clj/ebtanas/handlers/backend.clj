(ns ebtanas.handlers.backend
  (:require [ebtanas.handlers.common :as handle.c]
            [ebtanas.views.backend :as views.back]))

(defn registration-response [req]
  (handle.c/wrap-text-html-ok
    (views.back/registration-response "Registration Result!" req)))