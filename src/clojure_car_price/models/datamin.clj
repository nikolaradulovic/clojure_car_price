(ns clojure_car_price.models.datamin
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]
            [clojure_car_price.models.cars :as cars-model]
            )
  (:use [incanter.core :only [sel to-matrix]]
        [incanter.stats :only [linear-model]]
        [incanter.charts  :as icharts]
        [incanter.core :only [view]]))



(defn write-csv []
  (let [columns [:mid :horsepower :yearprod :kilometres :price]
        headers  (map name columns)
        result (cars-model/carsForExport)
        rows  (mapv #(mapv % columns) result)]
    (with-open [file (io/writer "result.csv")]
      (csv/write-csv file (cons headers rows)))))

(use 'incanter.io)
(def data (read-dataset "result.csv" :header true))


(def carPrice (sel data :cols 4))
(def carMileage (sel data :cols 3))
(def carHP (sel data :cols 1))
(def carYear (sel data :cols 2))

(defn ols-linear-model [Y X]
  (linear-model Y X))

(defn make-scatter-plot-chart [X Y]
  (icharts/scatter-plot X Y))

(defn plot-model [X Y] (view
                         (icharts/add-lines (make-scatter-plot-chart X Y)
                           X (:fitted (ols-linear-model Y X)))))


(defn plotPriceMileage []
  (plot-model carPrice carMileage))

(defn plotPriceHP []
  (plot-model carPrice carHP))

(defn plotPriceYear []
  (plot-model carPrice carYear))










