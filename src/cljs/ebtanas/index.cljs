(ns ebtanas.index
  (:require [reagent.core :as reagent :refer [atom]]
            [ebtanas.comcom :as common]))

(enable-console-print!)

(defonce app-state (atom {:text "Hello Chestnut! from Index"}))

;(defn greeting []
;  [:h1 (:text @app-state)])

(defn page []
  [:div
   [common/header]])

(reagent/render [page] (js/document.getElementById "app"))
