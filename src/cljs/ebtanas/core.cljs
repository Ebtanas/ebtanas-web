(ns ebtanas.core
  (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(defonce app-state (atom {:text "Hello Chestnut! from Index"}))

(defn greeting []
  [:h1 (:text @app-state)])

(reagent/render [greeting] (js/document.getElementById "app"))
