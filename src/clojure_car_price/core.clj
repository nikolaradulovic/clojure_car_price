(ns clojure_car_price.core
(:use compojure.core)
(:require [compojure.handler :as handler]
          [compojure.route :as route]
          [clojure_car_price.controllers.index :as index-controller]))

(defroutes app-routes
  (GET "/" [] (index-controller/index))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
