(ns ebtanas.db.connection)

(def *db*
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname "//localhost:5432/ebtanas_dev"
   :user "global"
   :password "global"
   :sslmode "require"})

