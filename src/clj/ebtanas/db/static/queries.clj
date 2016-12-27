(ns ebtanas.db.static.queries
  (:require [ebtanas.db.static.db :as static.db]))

(defn public-header-nav []
  @static.db/public-header-nav)

(defn public-footer-nav []
  @static.db/public-footer-nav)

(defn copyright []
  @static.db/copyright)

(defn matpel []
  @static.db/matpel)

(defn front-logo []
  @static.db/front-logo)

(defn get-items
  [f-that-access-atom]
  (f-that-access-atom))

(defn get-page-title [id]
  (get-in @static.db/pages [id :title]))

(defn get-pub-header-nav-path [id]
  (get-in @static.db/public-header-nav [id :path]))

(defn get-pub-footer-nav-paths []
  (map #(% :path) @static.db/public-footer-nav))