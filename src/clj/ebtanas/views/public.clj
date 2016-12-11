(ns ebtanas.views.public
  (:require [ebtanas.views.common :as common :refer [layout footer-js]]
            [ebtanas.db.static-queries :refer [get-items] :as atm]))

(defn home
  [title req]
  (layout title (common/public-navbar req) (common/public-footer)
          [:section#home.body.section.columns
           [:section.container.grid-960
            [:div.front-logo.text-center
             [:h1 ((get-items atm/front-logo) :name)]]
            [:div.col-xs-12.centered.text-left
             [:div.search-form.column.col-11.centered
              [:form.form-horizontal
               [:div.input-group
                [:select..form-select2.form-select.select-lg
                 [:option "Semua"]
                 (for [item (get-items atm/matpel)]
                   [:option (item :matpel)])]
                [:input.form-input.input-lg
                 {:type "text"
                  :placeholder "e.g. metabolisme"}]
                [:button.btn.btn-primary.input-group-btn.btn-lg
                 [:span.icon.icon-search]]]]]]]]))

(defn koleksi-soal
  [title req]
  (layout title (common/public-navbar req) (common/public-footer)
          [:section.body.section.columns
           [:section.container.grid-960.mt-10
            [:div.masonry-layout
             (for [item (get-items atm/matpel)]
               [:div.masonry-layout-panel
                [:h3 (item :matpel)]
                [:ul (for [chapter (item :chapters)]
                       [:dt chapter])]])]]]))

(defn daftar-anggota
  [title req]
  (layout title
          (common/public-navbar req)
          (common/public-footer
            ((footer-js) "ebtanas.pub.sign_up" "/js/compiled/sign_up.js"))))

(defn masuk-halaman
  [title req]
  (layout title
          (common/public-navbar req)
          (common/public-footer
            ((footer-js) "ebtanas.pub.sign_in" "/js/compiled/sign_in.js"))))