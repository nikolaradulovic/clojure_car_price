(ns clojure_car_price.controllers.index
  (:require
    [clostache.parser :as clostache]
    [clojure_car_price.models.cars :as cars-model]))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
           (str "views/pages/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn index []
  (render-template "index" {:cars (cars-model/all)}))
