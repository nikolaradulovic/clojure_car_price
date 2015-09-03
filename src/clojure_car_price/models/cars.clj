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
    ["SELECT c.id, c.model, c.horsepower, c.yearprod, c.kilometres, m.name FROM car c
    LEFT JOIN manufracturer m on c.manufracturerid = m.manufracturerid"]))

;(defn allManufractures []
;  (j/query mysql-db
;    ["SELECT m.manufracturerid id, m.name name, m.yearfounded year, cy.name head, c.name country FROM manufracturer m left join country c on m.countryid = c.countryId
;  left join city cy on m.cityId = cy.cityId"]))

(defn insertNewCar [params]
  (j/insert! mysql-db :car params))

(defn updateCar [id params]
  (j/update! mysql-db :car params (s/where {:id id})))

(defn removeCar [id]
  (j/delete! mysql-db :car (s/where {:id id})))


(defn calculate [params]
  (def m (params :model))
  (def y (params :year))
  (def hpw (params :hp))
  (def mil (params :mileage))
  + 2 y
  )



(defn form-handler [request]
  {:status 200
   :headers {"Content-type" "text/plain"}
   :body (str "params:\n" (:params request) "\nquery-params:\n" (:query-params request) "\nform-params:\n" (:form-params request))})

