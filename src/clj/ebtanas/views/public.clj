(ns ebtanas.views.public
  (:require [ebtanas.views.common :as common :refer [page footer-js]]
            [ebtanas.views.db :as views.db]))

(defn home
  [title req]
  (page title (common/navbar req) (common/footer)
        [:section.body.section.columns
         [:section.container.grid-960
          [:div.front-logo.text-center [:h1 (@views.db/front-logo :name)]]
          [:div.col-xs-12.centered.text-left
           [:div.search-form.column.col-11.centered
            [:form.form-horizontal
             [:div.input-group
              [:select.form-select.select-lg
               [:option "Semua"]
               (for [item @views.db/matpel]
                 [:option (item :matpel)])]
              [:input.form-input.input-lg
               {:type "text"
                :placeholder "e.g. metabolisme"}]
              [:button.btn.btn-primary.input-group-btn.btn-lg
               [:span.icon.icon-search]]]]]]]]))

(defn koleksi-soal
  [title req]
  (page title (common/navbar req) (common/footer)
        [:section.body.section.columns
         [:section.container.grid-960.mt-10
          [:div.masonry-layout
           (for [item @views.db/matpel]
             [:div.masonry-layout-panel
              [:h3 (item :matpel)]
              [:ul (for [chapter (item :chapters)]
                     [:dt chapter])]])]]]))

(defn daftar-anggota
  [title req]
  (page title
        (common/navbar req)
        (common/footer (footer-js "ebtanas.pub.daftar_anggota"))
        nil))


(defn masuk-halaman
  [title req]
  (page title
        (common/navbar req)
        (common/footer)
        [:h1 "Masuk Halaman"]))