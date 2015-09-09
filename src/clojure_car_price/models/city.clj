(ns clojure_car_price.models.city
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as j]
				[clojure.java.jdbc.sql :as s]))

(def mysql-db {:subprotocol "mysql"
					 :subname "//localhost:3306/carsdb"
					 :user "root"
					 :pass " "
					 :zeroDateTimeBehaviour "convertToNull"})

(defn allCities []
  (j/query mysql-db
    ["SELECT * from city"]))