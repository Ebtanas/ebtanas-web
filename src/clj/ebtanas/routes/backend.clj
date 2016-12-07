(ns ebtanas.routes.backend
  (:require [compojure.core :refer [defroutes GET]]))

(defroutes backend-routes
  (GET "/admin/:adm-page-id" [] "Under Construction!")
  (GET "/manager/:man-page-id" [] "Under Construction!")
  (GET "/member/:mem-page-id" [] "Under Construction!"))
