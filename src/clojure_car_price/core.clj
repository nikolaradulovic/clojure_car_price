(ns clojure_car_price.core
(:use compojure.core)
(:require [compojure.handler :as handler]
          [compojure.route :as route]
          [ring.middleware.basic-authentication :refer :all]
          [ring.util.response :as resp]
          [clojure_car_price.models.cars :as cars-model]
          [clojure_car_price.controllers.index :as cars-controller]))
;          [clojure_car_price.controllers.admin.cars :as admin-cars-controller]))

;(defn authenticated? [name pass]
;  (and (= name "user")
;    (= pass "pass")))


(defroutes public-routes
  (GET "/" [] (cars-controller/index))
  (route/resources "/" )
  (GET "/index" [] (cars-controller/index))
  (route/resources "/")
  (GET "/manufractures" [] (cars-controller/manufractures))
  (route/resources "/")
  (GET "/weka" [] (cars-controller/weka))
  (route/resources "/")
  (GET "/newcar" [] (cars-controller/newcar))
  (route/resources "/")
  (GET "/updatecar" [] (cars-controller/updatingCars))
  (route/resources "/")

  (POST "/models/cars/create" [& params]
  (do (cars-model/insertNewCar params)
    (resp/redirect "/index")))
  (POST "/models/cars/calculate" {params :params}
    do(cars-model/calculate params))
  (POST "/models/cars/form-handler" {params :require}
    do(cars-model/form-handler params)))





(defroutes app-routes
  public-routes
;  (wrap-basic-authentication protected-routes authenticated?)
  (route/not-found "404 Not Found"))

(def app
  (handler/site app-routes))
