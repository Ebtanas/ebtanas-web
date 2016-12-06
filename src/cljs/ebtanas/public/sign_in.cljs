(ns ebtanas.pub.sign-in
  (:require [reagent.core :as reagent]
            [ebtanas.pub.common :refer [input] :as pub.common]))

(enable-console-print!)

(defn main []
  [pub.common/form-layout-two-columns
   [pub.common/widget "Masuk Halaman Anggota"]
   [:div.columns
    [:div.column
     [:form.form-horizontal
      [pub.common/form-group
       [:label.form-label "Email"]
       [input "email" "email" "form-input" "email" "e.g. bcl@gmail.com"]
       nil "col-6"]
      [pub.common/form-group
       [:label.form-label "Password"]
       [input "password" "password" "form-input" "password" "********"]
       nil "col-8"]
      [pub.common/form-group
       [:label.form-label]
       [:label.form-checkbox
        [input "checkbox" nil nil nil]
        [:i.form-icon] "Ingat saya!"]
       nil "col-8"]
      [pub.common/form-group
       [:label.form-label]
       [:label.form-label]]
      [pub.common/form-group
       [:label.form-label]
       [:button.btn.btn-primary.mr-10 {:type "submit"} "Masuk"]
       nil "col-7"]]]]])

(reagent/render [main]
  (js/document.getElementById "reactive"))