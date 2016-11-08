;; comcom -> common component

(ns ebtanas.comcom
  (:require [reagent.core :as reagent]
            [goog.string :as gstr]))

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

(defn header-columns []
  [:section {:className "container columns col-11 centered"}
   [header-menu-container]])

(defn header []
  [:section {:className "section header columns"}
   [header-columns]])

;; FOOTER COMPONENT

(defn footer-menu-container-left []
  [:ul {:className "tab inline-flex hide-xs"}
   [:li {:className "mr-10"}
    [:a {:href "#"} "Kebijakan Privasi"]]
   [:li {:className "ml-10 mr-10"}
    [:a {:href "#"} "Contekan"]]
   [:li {:className "ml-10"}
    [:a {:href "#"} "Misi Ebtanas"]]])

(defn footer-menu-container-right []
  [:ul {:className "tab inline-flex"}
   [:li {:className "tab inline-flex"}
    (gstr/unescapeEntities "&copy;") " Hak Cipta 2017 - Indonesia"]])

(defn footer-column-left []
  [:div {:className "column col-xs-12 float-left text-left"}
   [footer-menu-container-left]])

(defn footer-column-right []
  [:div {:className "column col-xs-12 float-right text-right"}
   [footer-menu-container-right]])

(defn footer-columns []
  [:section {:id "copyright" :className "container columns col-11 centered"}
   [footer-column-left]
   [footer-column-right]])

(defn footer []
  [:footer {:className "section footer mt-10 bg-grey"}
   [footer-columns]])