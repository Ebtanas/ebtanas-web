(ns ebtanas.handlers.validation
  (:require [bouncer.core :as b]
            [bouncer.validators :as v]))

(def date-regex #"^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$")

(v/defvalidator required
  {:default-message-format "* tidak boleh kosong!"
   :optional false}
  [value]
  (if (string? value)
    (not (empty? value))
    (not (nil? value))))

(defn registration-validation
  [{:keys [password] :as params}]
  (first
    (b/validate
      params
      :first_name [required
                   [v/max-count 10 :message "Panjang nama depan maksimal 10 karakter!"]
                   [v/matches #"^[A-Z][a-zA-Z]*$" :message "Tidak boleh ada spasi atau digit! minimal 1 karakter!"]]
      :last_name [required
                  [v/max-count 20 :message "Panjang nama belakang maksimal 20 karakter"]
                  [v/matches #"^[a-zA-z]+([ '-][a-zA-Z]+)*$" :message "Tidak boleh ada digit atau ada spasi diakhir! minimal 1 karakter!"]]
      :email [required
              [v/matches #"^[^@]+@[^@\\.]+[\\.].+$" :message "Format email salah! tidak boleh ada spasi!"]]
      :birthday [required
                 [v/max-count 10 :message "Panjang karakter maksimal 10 karakter"]
                 [v/matches date-regex :message "Format tanggal salah! eg. 29/04/1993"]]
      :password [required
                 [v/min-count 8 :message "Panjang password minimal 8 karakter!"]]
      :pass-confirm [required
                     [v/min-count 8 :message "Panjang password minimal 8 karakter!"]
                     [= password :message "Password yang dimasukan tidak sama!"]])))