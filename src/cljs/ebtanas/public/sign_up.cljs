(ns ebtanas.pub.sign-up
  (:require [reagent.core :as reagent]
            [ebtanas.pub.common :refer [input] :as pub.common]
            [ebtanas.handlers.validation :as validation]))

(enable-console-print!)

(defonce fields (reagent/atom {:fields {:sex "other"}
                               :alerts {}}))

(defn swapin [param]
  (fn [e]
    (swap! fields assoc-in [:fields param] (-> e .-target .-value))))

(defn alert-message [param]
  (swap! fields assoc-in [:alerts param]
         (when-let
           [message (-> (@fields :fields)
                        (validation/registration-validation)
                        param
                        (first))]
           message)))

(defn alertin [param]
  (fn [] (alert-message param)))

(defn disablein [state]
  (if (-> state
          (validation/registration-validation)
          (first)
          (nil?))
    false
    true))

(defn clickTab [param]
  (fn [e]
    (when (= (.-keyCode e) 9)
      (alert-message param))))


(defn main []
  [pub.common/form-layout-two-columns
   [pub.common/widget "Daftar Anggota"]
   [:div.columns
    [:div.column
     [:form.form-horizontal {:method "POST" :action "/panel"}
      [pub.common/form-group
       [:label.form-label "Nama Depan"]
       [:div
        [:p
         [input
          "text"
          "input-first-name"
          "form-input"
          "first_name"
          "e.g. Bunga"
          {:onChange (swapin :first_name)
           :onMouseLeave (alertin :first_name)
           :onKeyDown (clickTab :first_name)}]]
        [:p [:small.alert (get-in @fields [:alerts :first_name])]]]]
      [pub.common/form-group
       [:label.form-label "Nama Belakang"]
       [:div
        [:p
         [input
          "text"
          "input-last-name"
          "form-input"
          "last_name"
          "e.g. Citra Lestari"
          {:onChange (swapin :last_name)
           :onMouseLeave (alertin :last_name)
           :onKeyDown (clickTab :last_name)}]]
        [:p [:small.alert (get-in @fields [:alerts :last_name])]]]]
      [pub.common/form-group
       [:label.form-label "Email"]
       [:div
        [:p
         [input
          "email"
          "input-email"
          "form-input"
          "email"
          "e.g. bcl@gmail.com"
          {:onChange (swapin :email)
           :onMouseLeave (alertin :email)
           :onKeyDown (clickTab :email)}]]
        [:p [:small.alert (get-in @fields [:alerts :email])]]]]
      [pub.common/form-group
       [:label.form-label "Tanggal Lahir"]
       [:div
        [:p
         [input
          "text"
          "input-date"
          "form-input"
          "birthdday"
          "e.g. 22/03/1983"
          {:onChange (swapin :birthday)
           :onMouseLeave (alertin :birthday)
           :onKeyDown (clickTab :birthday)}]]
        [:p [:small.alert (get-in @fields [:alerts :birthday])]]]]
      [pub.common/form-group
       [:label.form-label "Sex"]
       [:div#sex
        [:p
         [:label.form-radio
          [input "radio" nil nil "sex" nil]
          [:i.form-icon] "Laki-Laki"]
         [:label.form-radio
          [input "radio" nil nil "sex" nil {:default-checked true}]
          [:i.form-icon] "Perempuan"]
         [:label.form-radio
          [input "radio" nil nil "sex" nil]
          [:i.form-icon] "Lainnya"]]]]
      [pub.common/form-group
       [:label.form-label "Password"]
       [:div
        [:p
         [input
          "password"
          "input-password"
          "form-input"
          "password"
          "e.g. !@34Ab%"
          {:onChange (swapin :password)
           :onMouseLeave (alertin :password)
           :onKeyDown (clickTab :password)}]]
        [:p [:small.alert (get-in @fields [:alerts :password])]]]
       nil "col-7"]
      [pub.common/form-group
       [:label.form-label "Ulangi Password"]
       [:div
        [:p
         [input
          "password"
          "input-password"
          "form-input"
          "pass-confirm"
          "e.g. !@34Ab%"
          {:onChange (swapin :pass-confirm)
           :onMouseLeave (alertin :pass-confirm)
           :onKeyDown (clickTab :pass-confirm)}]]
        [:p [:small.alert (get-in @fields [:alerts :pass-confirm])]]]
       nil "col-7"]
      [pub.common/form-group
       [:label.form-label]
       [:label.form-label]]
      [pub.common/form-group
       [:label.form-label]
       [:div
        [:button#submit.btn.btn-primary.mr-10 {:type "submit" :disabled (disablein (@fields :fields))} "Daftar"]]
       nil "col-7"]]]]])

(reagent/render [main]
  (js/document.getElementById "reactive"))