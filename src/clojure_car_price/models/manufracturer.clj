(ns clojure_car_price.models.manufracturer
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as j]
	    [clojure.java.jdbc.sql :as s]))

(def mysql-db {:subprotocol "mysql"
	       :subname "//localhost:3306/carsdb"
	       :user "root"
	       :pass " "
	       :zeroDateTimeBehaviour "convertToNull"})

(defn get [id]
  (first (j/query mysql-db
    (s/select * :manufracturer (s/where {:manufracturerId id})))))

(defn allManufractures []
  (j/query mysql-db
    ["SELECT m.manufracturerid id, m.name name, m.yearfounded year, cy.name head, c.name country FROM manufracturer m left join country c on m.countryid = c.countryId
	left join city cy on m.cityId = cy.cityId"]))

(defn updateManu [id params]
  (j/update! mysql-db :manufracturer params (s/where {:manufracturerId id})))
  
(defn insertNewMan [params]
  (j/insert! mysql-db :manufracturer params))
  
(defn removeMan [id]
  (j/delete! mysql-db :manufracturer (s/where {:id id})))
