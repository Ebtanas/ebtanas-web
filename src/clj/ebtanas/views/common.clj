(ns ebtanas.views.common
  (:require [hiccup.page :refer [html5 include-css include-js]]
            [ebtanas.db.static.queries :refer [get-items] :as atm]
            [config.core :refer [env]]))

(defn footer-js-min [_ & args]
  [:div
   (include-js "/js/compiled/out/cljs_base.js")
   (when args
     (for [js args]
       (include-js js)))])

(defn footer-js-dev [ns _ & args]
  [:div
   (include-js "/js/compiled/out/goog/base.js")
   (include-js "/js/compiled/app.js")
   [:script {:type "text/javascript"}
    (str "goog.require('" ns "');")]
   (when args
     (for [js args]
       (include-js js)))])

;; not-pure fn
(defn footer-js []
  (if (= (env :profile) "dev")
    footer-js-dev
    footer-js-min))

(defn layout
  [title header footer & [body]]
  (html5 [:head
          [:meta {:charset "utf-8"}]
          [:title title]
          (include-css "/css/base.css")
          (include-css "/assets/spectre.css/demo/font/style.css")
          (include-css "/assets/spectre.css/dist/spectre.min.css")]
         [:body [:div#app header [:div#reactive body] footer]]))

(defn public-navbar [req]
  [:section.header.selection.columns
   [:section.container.columns.col-11.centered
    [:div.column.col-xs-12.float-right.text-right
     [:ul.tab.inline-flex
      (for [item (get-items atm/public-header-nav)]
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
      (for [item (get-items atm/public-footer-nav)]
        [:li.mr-20
         [:a {:href (str "/page" (item :path))}
          (str (item :title))]])]]
    [:div.column.col-xs-12.float-right.text-right
     [:ul.tab.inline-flex
      [:li (interpose " " (vals (get-items atm/copyright)))]]]]
   [:div.footer-scripts js]])


