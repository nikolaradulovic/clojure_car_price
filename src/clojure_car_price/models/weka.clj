(ns clojure_car_price.models.weka
(:require [clojure.data.csv :as csv]
  [clojure.java.io :as io]
  [clojure.java.jdbc :as j]
  [clojure.java.jdbc.sql :as s]
  [clojure_car_price.models.cars :as cars-model]
 ))


(defn write-csv []
  (let [columns [:mid :horsepower :yearprod :kilometres :price]
         headers  (map name columns)
         result (cars-model/carsForExport)
         rows  (mapv #(mapv % columns) result)]
  (with-open [file (io/writer "result.csv")]
     (csv/write-csv file (cons headers rows)))))

