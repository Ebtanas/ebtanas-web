(ns ebtanas.views.common
  (:require [hiccup.page :refer [html5 include-css include-js]]
            [ebtanas.views.db :as views.db]
            [config.core :refer [env]]))

(defn footer-js-min [_ & args]
  [:div
   (include-js "/js/compiled/app.js")
   (when args
     (for [js args]
       (include-js js)))])

(defn footer-js-dev [ns & args]
  [:div
   (include-js "/js/compiled/out/goog/base.js")
   (include-js "/js/compiled/app.js")
   [:script {:type "text/javascript"}
    (str "goog.require('" ns "');")]
   (when args
     (for [js args]
       (include-js js)))])

(defn footer-js []
  (if (= (env :profile) "dev")
    footer-js-dev
    footer-js-min))

(defn page
  [title header footer & [body]]
  (html5 [:head
          [:meta {:charset "utf-8"}]
          [:title title]
          (include-css "/css/base.css")
          (include-css "/css/fonts.css")
          (include-css "/css/spectre.min.css")]
         [:body [:div#app header [:div#reactive body] footer]]))

(defn public-navbar [req]
  [:section.header.selection.columns
   [:section.container.columns.col-11.centered
    [:div.column.col-xs-12.float-right.text-right
     [:ul.tab.inline-flex
      (for [item @views.db/public-header-nav]
        [:li.tab-item {:class (when (= (req :uri) (item :path))
                                (str "active"))}
         [:a {:href (str (item :path))}
          [:span {:class (str "icon " (item :icon))}]
          (str " " (item :title))]])]]]])

(defn public-footer [& [js]]
  [:footer.footer.section.mt-10.bg-grey
   [:section#copyright.container.columns.col-11.centered
    [:div.column.col-xs-12.float-left.text-left
     [:ul.tab.inline-flex
      (for [item @views.db/public-footer-nav]
        [:li.mr-20
         [:a {:href (str (item :path))}
          (str (item :title))]])]]
    [:div.column.col-xs-12.float-right.text-right
     [:ul.tab.inline-flex
      [:li (interpose " " (vals @views.db/copyright))]]]]
   [:div.footer-scripts js]])


