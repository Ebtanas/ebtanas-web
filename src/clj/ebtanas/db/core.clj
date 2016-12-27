(ns ebtanas.db.core
  (require [ebtanas.db.connection :refer [db-con]]
           [ebtanas.db.sql :as sql]))

(defn users-all []
  (sql/users-all db-con))

(defn create-user! [map-args]
  "map-args: {:id <string>
              :password <string>}"
  (sql/create-user! db-con map-args))