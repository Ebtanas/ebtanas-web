(ns ebtanas.views.public
  (:require [ebtanas.views.common :refer [page]]))

(defn home [title]
  (page title
    [:h1 "Hello World"]))
