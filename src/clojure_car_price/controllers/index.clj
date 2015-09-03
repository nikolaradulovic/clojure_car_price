(ns clojure_car_price.controllers.index
  (:require
    [clostache.parser :as clostache]
    [clojure_car_price.models.cars :as cars-model]
    [clojure_car_price.models.manufracturer :as man-model]
    ))


(defn read-template [template-name]
  (slurp (clojure.java.io/resource
           (str "views/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn index []
  (render-template "index" {:cars (cars-model/allCars)}))

(defn updatingCars [id]
  (render-template "updatecar" {:car (cars-model/get id)
                                :manufracturers (man-model/allManufractures)
                                }))


(defn manufractures []
  (render-template "manufractures" {:manufracturers (man-model/allManufractures)}))

(defn weka []
  (render-template "weka" {}))

(defn newcar []
  (render-template "newcar" {:manufracturers (man-model/allManufractures)}))




;(defn weka []
;  (render-template "weka" {:cars (cars-model/allCars)}))