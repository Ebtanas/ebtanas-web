-- :name users-all :? :*
-- :doc select all the users with all the attributes
SELECT *
  FROM "USERS"
order by id;

-- :name create-user! :! :n
-- :doc creates a new user record
INSERT INTO "USERS"
    (id, password)
VALUES
    (:id, :password);