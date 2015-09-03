(ns clojure_car_price.models.manufracturer
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/carsdb"
               :user "root"
               :pass " "
               :zeroDateTimeBehaviour "convertToNull"})


(defn allManufractures []
  (j/query mysql-db
    ["SELECT m.manufracturerid id, m.name name, m.yearfounded year, cy.name head, c.name country FROM manufracturer m left join country c on m.countryid = c.countryId
  left join city cy on m.cityId = cy.cityId"]))