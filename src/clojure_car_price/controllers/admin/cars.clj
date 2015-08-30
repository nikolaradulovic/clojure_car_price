(ns clojure_car_price.controllers.admin.cars
  (:require
    [clostache.parser :as clostache]
    [clojure_car_price.models.cars :as cars-model]))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
           (str "views/admin/cars/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn index []
  (render-template "index" {:posts (cars-model/allCars)}))

(defn show [id]
  (render-template "show" {:post (cars-model/get id)}))

(defn edit [id]
  (render-template "edit" {:post (cars-model/get id)}))

;(defn new []
;  (render-template "new" {}))