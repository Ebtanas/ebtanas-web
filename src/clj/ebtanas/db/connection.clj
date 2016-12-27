(ns ebtanas.db.connection
  (require [config.core :refer [env]]))

(defonce db-con
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname (get-in env [:config :database-url])
   :user (get-in env [:config :user])
   :password (get-in env [:config :password])})

