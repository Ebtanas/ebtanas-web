-- :name users-all :? :*
-- :doc select all the users with all the attributes
SELECT *
  FROM "users"
order by id;

-- :name create-user! :! :n
-- :doc creates a new user record
INSERT INTO "users"
    (created, first_name, last_name, email, password, birthday, sex)
VALUES
    (:created, :first_name, :last_name, :email, :password, :birthday, :sex);