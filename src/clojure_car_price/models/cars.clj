(ns clojure_car_price.models.cars
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/carsdb"
               :user "root"
               :pass " "
               :zeroDateTimeBehaviour "convertToNull"})

(def now
  (str (java.sql.Timestamp. (System/currentTimeMillis))))

;(defn all []
;  (j/query mysql-db
;    (s/select * :car)))

(defn get [id]
  (first (j/query mysql-db
           (s/select * :car (s/where {:id id})))))

(defn allCars []
  (j/query mysql-db
    ["SELECT c.model, c.horsepower, c.yearprod, c.kilometres, m.name FROM car c
    LEFT JOIN manufracturer m on c.manufracturerid = m.manufracturerid"]))

(defn allManufractures []
  (j/query mysql-db
    ["SELECT m.name name, m.yearfounded year, cy.name head, c.name country FROM manufracturer m left join country c on m.countryid = c.countryId
  left join city cy on m.cityId = cy.cityId"]))
