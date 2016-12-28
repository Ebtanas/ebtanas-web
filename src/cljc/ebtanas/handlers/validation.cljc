(ns ebtanas.handlers.validation
  (:require [bouncer.core :as b]
            [bouncer.validators :as v]))


(v/defvalidator required
  {:default-message-format "* tidak boleh kosong!"
   :optional false}
  [value]
  (if (string? value)
    (not (empty? value))
    (not (nil? value))))

(defn registration-validation
  [{:keys [pass-confirm] :as params}]
  (first
    (b/validate
      params
      :first_name [required
                   [v/max-count 10 :message "Panjang nama depan maksimal 10 karakter!"]
                   [v/matches #"[A-Z][a-zA-Z]*" :message "Tidak boleh ada whitespaces!, digit, dan minimal 1 karakter!"]]
      :last_name [required
                  [v/max-count 15 :message "Panjang nama belakang maksimal 20 karakter"]
                  [v/matches #"[a-zA-z]+([ '-][a-zA-Z]+)*" :message "Tidak boleh ada whitespaces!, digit, dan minimal 1 karakter!"]]
      :email [required
              [v/email :message "Format email salah! eg. nama@domain.com"]]
      :birthday [required
                 [v/datetime "dd/mm/yyyy" :message "Format tanggal salah! eg. 29/04/1993"]]
      :password [required
                 [v/min-count 8 :message "Panjang password minimal 8 karakter!"]
                 [= pass-confirm :message "Password yang dimasukan tidak sama!"]])))
