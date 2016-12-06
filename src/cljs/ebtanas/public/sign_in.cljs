(ns ebtanas.pub.sign-in
  (:require [reagent.core :as reagent]
            [ebtanas.pub.common :refer [input] :as pub.common]))

(enable-console-print!)

(defn main []
  [:h1 "Hello World from Sign-in"])

(reagent/render [main]
  (js/document.getElementById "reactive"))