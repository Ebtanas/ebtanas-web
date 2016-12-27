(ns ebtanas.db.sql
  (require [hugsql.core :as hugsql]))

(hugsql/def-db-fns "ebtanas/db/sql/user_queries.sql")