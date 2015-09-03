(ns clojure_car_price.models.country
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/carsdb"
               :user "root"
               :pass " "
               :zeroDateTimeBehaviour "convertToNull"})

(defn allCountries []
  (j/query mysql-db
    ["SELECT * from country"]))