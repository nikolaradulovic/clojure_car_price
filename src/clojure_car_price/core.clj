(ns clojure_car_price.core
(:use compojure.core)
(:require [compojure.handler :as handler]
          [compojure.route :as route]
          [ring.middleware.basic-authentication :refer :all]
          [ring.util.response :as resp]
          [clojure_car_price.models.cars :as cars-model]
          [clojure_car_price.controllers.index :as cars-controller]
          [clojure_car_price.controllers.admin.cars :as admin-cars-controller]))

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
  (GET "/weka" [] (cars-controller/manufractures))
  (route/resources "/"))

(defroutes protected-routes
  (GET "/admin" [] (admin-cars-controller/index))
  (GET "/admin" [id] (admin-cars-controller/show id))
  ;  (GET "/admin/cars/new" [] (admin-cars-controller/new))
  ;  (POST "/admin/cars/create" [& params]
  ;    (do (cars-model/create params)
  ;      (resp/redirect "/admin")))
  (GET "/admin/cars/:id/edit" [id] (admin-cars-controller/edit id))
  ;  (POST "/admin/cars/:id/save" [& params]
  ;    (do (cars-model/save (:id params) params)
  ;      (resp/redirect "/admin")))
  ;  (GET "/admin/cars/:id/delete" [id]
  ;    (do (cars-model/delete id)
  ;      (resp/redirect "/admin")))
  )

(defroutes app-routes
  public-routes
;  (wrap-basic-authentication protected-routes authenticated?)
  (route/not-found "404 Not Found"))

(def app
  (handler/site app-routes))
