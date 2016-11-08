(ns ebtanas.index
  (:require [reagent.core :as reagent :refer [atom]]
            [ebtanas.comcom :as common]
            [goog.string :as gstr]))

(enable-console-print!)

(defonce app-state (atom {:input-items [{:item "Cari Semua..."}
                                        {:item "Matematika IPA"}
                                        {:item "Matematika IPS"}
                                        {:item "Bahasa Indonesia"}
                                        {:item "Bahasa Inggris"}
                                        {:item "Fisika"}
                                        {:item "Biologi"}
                                        {:item "Kimia"}
                                        {:item "Sosiologi"}
                                        {:item "Geografi"}
                                        {:item "Ekonomi"}]}))

(defn logo []
  [:div {:className "front-logo text-center"}
   [:h1 "Ebtanas, delibrate soal UN!"]])

(defn select-items []
  [:select {:className "form-select select-lg"}
   (for [item (map-indexed vector (@app-state :input-items))]
     ^{:key (first item)} [:option ((second item) :item)])])

(defn search-box []
  [:input {:type "text"
           :className "form-input input-lg"
           :placeholder "contoh: metabolisme pada hewan"}])

(defn search-button []
  [:button {:className "btn btn-primary input-group-btn btn-lg"}
   [:span {:className "icon icon-search"}]])

(defn search-form []
  [:form {:className "form-horizontal"}
   [:div {:className "input-group"}
    [select-items]
    [search-box]
    [search-button]]])

(defn search-container []
  [:div {:className "search-body col-xs-12 centered text-left"}
   [:div {:className "search-form column col-11 centered"}
    [search-form]]])

(defn page-body []
  [:section {:className "section body-style columns"}
   [:section {:className "container grid-960"}
    [logo]
    [search-container]]])

(defn page []
  [:div
   [common/header]
   [page-body]
   [common/footer]])

(reagent/render [page] (js/document.getElementById "app"))