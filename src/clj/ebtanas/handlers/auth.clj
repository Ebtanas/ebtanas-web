(ns ebtanas.handlers.auth
  (require [ebtanas.db.core :as db]
           [ebtanas.handlers.validation :refer [registration-validation]]
           [ring.util.http-response :as response]
           [buddy.hashers :as hashers]
           [clojure.tools.logging :as log]
           [clj-time.jdbc]
           [clj-time.local :as time.local]
           [clj-time.format :as time.format]))

(defn parse-birthday [birthday]
  (time.format/parse
    (time.format/formatter "dd/MM/yyyy")
    birthday))

(defn handle-registration-error [e]
  (if (-> e (.getNextException)
          (.getMessage)
          (.startsWith "ERROR: duplicate key value"))
    (response/precondition-failed
      {:result :error
       :message "User with selected ID already exists! (ns. auth 1)"})
    (do
      (log/error e)
      (response/internal-server-error
        {:result :error
         :message "Server error while adding the user! (ns. auth 2)"}))))

(defn register!
  [{:keys [session]} user]
  (if (registration-validation user)
    (response/precondition-failed
      {:result :error
       :message "Please check your input! (ns. auth 3)"})
    (try
      (db/create-user!
        (-> user
            (assoc :created (time.local/local-now))
            (dissoc :pass-confirm)
            (update :password hashers/encrypt)
            (update :birthday parse-birthday)))
      (-> {:result :ok}
          (response/ok)
          (assoc :session (assoc session :identity (user :email))))
      (catch Exception e
        (handle-registration-error e)))))