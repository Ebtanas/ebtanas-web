(ns ebtanas.pub.sign-up
  (:require [reagent.core :as reagent]
            [ebtanas.pub.common :refer [input] :as pub.common]))

(enable-console-print!)

(defn main []
  [pub.common/form-layout-two-columns
   [pub.common/widget "Daftar Anggota"]
   [:div.columns
    [:div.column
     [:form.form-horizontal
      [pub.common/form-group
       [:label.form-label "Nama Depan"]
       [input "text" "input-first-name" "form-input" "name" "e.g. Bunga"]]
      [pub.common/form-group
       [:label.form-label "Nama Belakang"]
       [input "text" "input-last-name" "form-input" "last_name" "e.g. Citra Lestari"]]
      [pub.common/form-group
       [:label.form-label "Email"]
       [input "email" "input-email" "form-input" "email" "e.g. bcl@gmail.com"]]
      [pub.common/form-group
       [:label.form-label "Tanggal Lahir"]
       [input "date" "input-date" "form-input" "birth_date" nil]]
      [pub.common/form-group
       [:label.form-label "Sex"]
       [:div
        [:label.form-radio
         [input "radio" nil nil "sex" nil]
         [:i.form-icon] "Laki-Laki"]
        [:label.form-radio
         [input "radio" nil nil "sex" nil {:default-checked true}]
         [:i.form-icon] "Perempuan"]]
       nil "col-7"]
      [pub.common/form-group
       [:label.form-label "Password"]
       [input "password" "input-password" "form-input" "password" "e.g. !@34Ab%"]
       nil "col-7"]
      [pub.common/form-group
       [:label.form-label "Ulangi Password"]
       [input "password" "input-password" "form-input" "password" "e.g. !@34Ab%"]
       nil "col-7"]
      [pub.common/form-group
       [:label.form-label]
       [:label.form-label]]
      [pub.common/form-group
       [:label.form-label]
       [:div
        [:button.btn.btn-primary.mr-10 {:type "submit"} "Daftar"]
        [:button.btn.btn-link {:type "reset"} "Batal deh!"]]
       nil "col-7"]]]]])

(reagent/render [main]
  (js/document.getElementById "reactive"))