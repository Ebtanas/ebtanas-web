(ns ebtanas.routes.services
  (:require [ebtanas.handlers.auth :as auth]
            [ring.util.http-response :as response]
            [compojure.api.sweet :as api]
            [schema.core :as schema]))

(schema/defschema Result
  {:result schema/Keyword
   (schema/optional-key :message) schema/Str})

(schema/defschema UserRegistration
  {:first_name schema/Str
   :last_name schema/Str
   :email schema/Str
   :password schema/Str
   :pass-confirm schema/Str
   :birthday schema/Str
   :sex (schema/enum "male" "female" "other")})

(api/defapi service-route
  {:swagger {:ui "/swagger-ui"
             :spec "/swagger.json"
             :data {:info {:version "1.0.0"
                           :title "Ebtanas API"
                           :description "Public Services"}}}}
  (api/POST "/daftar" req
            :return Result
            :body [user UserRegistration]
            :summary "register a new user"
            (auth/register! req user)))



