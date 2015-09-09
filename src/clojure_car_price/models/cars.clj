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

(defn get [id]
  (first (j/query mysql-db
    (s/select * :car (s/where {:id id})))))

(defn allCars []
  (j/query mysql-db
    ["SELECT c.id, c.model, c.horsepower, c.yearprod, c.kilometres, c.price, m.name FROM car c
    LEFT JOIN manufracturer m on c.manufracturerid = m.manufracturerid"]))

(defn carsForExport []
  (j/query mysql-db
    ["SELECT c.horsepower, c.yearprod, c.kilometres, c.price, m.manufracturerId as mid FROM car c
    LEFT JOIN manufracturer m on c.manufracturerid = m.manufracturerid"]))
	

(defn insertNewCar [params]
  (j/insert! mysql-db :car params))

(defn updateCar [id params]
  (j/update! mysql-db :car params (s/where {:id id})))

(defn removeCar [id]
  (j/delete! mysql-db :car (s/where {:id id})))

