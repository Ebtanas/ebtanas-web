;; comcom -> common component

(ns ebtanas.comcom
  (:require [reagent.core :as reagent]))

;; HEADER COMPONENT

(defn header-menu-items []
  [:ul {:className "tab inline-flex hide-xs"}
   [:li {:className "tab-item active"}
    [:a {:href "#"}
     [:span {:className "icon icon-home"}]
     " Halaman Utama"]]
   [:li {:className "tab-item"}
    [:a {:href "#"}
     [:span {:className "icon icon-library_books"}]
     " Koleksi Soal"]]
   [:li {:className "tab-item"}
    [:a {:href "#"}
     [:span {:className "icon icon-people"}]
     " Daftar Anggota"]]
   [:li {:className "tab-item"}
    [:a {:href "#"}
     [:span {:className "icon icon-exit_to_app"}]
     " Masuk"]]])

(defn header-menu-container []
  [:div {:className "column col-xs-12 float-right text-right"}
   [header-menu-items]])

(defn header-column []
  [:section {:className "container columns col-11 centered"}
   [header-menu-container]])

(defn header []
  [:section {:className "section header columns"}
   [header-column]])

;; FOOTER COMPONENT