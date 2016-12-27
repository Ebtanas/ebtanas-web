(ns ebtanas.db.connection
  (require [environ.core :as environ]))

(defonce db-con
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname (environ/env :database-url)
   :user (environ/env :user)
   :password (environ/env :password)})

