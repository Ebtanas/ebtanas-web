(ns ebtanas.views.common
  (:require [hiccup.page :refer [html5 include-css include-js]]))

(defn page [title & body]
  (html5 [:head
          [:title title]
          (include-css "/css/base.css")]
         [:body body]))


