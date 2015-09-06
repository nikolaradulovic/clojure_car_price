(ns clojure_car_price.core
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.basic-authentication :refer :all]
            [ring.util.response :as resp]
            [clojure_car_price.models.cars :as cars-model]
            [clojure_car_price.models.manufracturer :as man-model]
            [clojure_car_price.controllers.index :as controller]
            [clojure_car_price.models.weka :as weka-model]))


;(defn authenticated? [name pass]
;  (and (= name "user")
;    (= pass "pass")))


(defroutes public-routes
  (GET "/" [] (controller/index))
  (route/resources "/" )
  (GET "/index" [] (controller/index))
  (route/resources "/")
  (GET "/manufractures" [] (controller/manufractures))
  (route/resources "/")
  (GET "/weka" [] (controller/weka))
  (route/resources "/")
  (GET "/newcar" [] (controller/newcar))
  (route/resources "/")
  (GET "/newman" [] (controller/newman))
  (route/resources "/")
  (GET "/models/cars/:id/update" [id] (controller/updatingCars id))
  (GET "/models/manufracturers/:manufracturerId/update" [manufracturerId] (controller/updatingMans manufracturerId))


  (GET "/models/weka/export" []
    (do (weka-model/write-csv)
      (resp/redirect "/index")))


  (GET "/models/cars/:id/remove" [id]
    (do (cars-model/removeCar id)
      (resp/redirect "/index")))

	  (GET "/models/manufracturers/:id/remove" [id]
    (do (man-model/removeMan id)
      (resp/redirect "/manufractures")))

	  
	  
  (POST "/models/cars/:id/updatecar" [& params]
    (do (cars-model/updateCar (:id params) params)
      (resp/redirect "/index")))

(POST "/models/manufracturers/:manufracturerId/updateman" [& params]
  (do (man-model/updateManu (:manufracturerId params) params)
    (resp/redirect "/manufractures")))

  (POST "/models/cars/create" [& params]
    (do (cars-model/insertNewCar params)
      (resp/redirect "/index")))
	  
	  
  (POST "/models/manufracturers/create" [& params]
    (do (man-model/insertNewMan params)
      (resp/redirect "/manufractures")))

  )

(defroutes app-routes
  public-routes
  ;  (wrap-basic-authentication protected-routes authenticated?)
  (route/not-found "404 Not Found"))

(def app
  (handler/site app-routes))
