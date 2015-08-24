(ns clojure_car_price.models.cars
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]))

(def mysql-db {:subprotocol "mysql"
               :subname "carprice.db"
               :user "root"
               :pass " "
               :zeroDateTimeBehaviour "convertToNull"})

(def now
  (str (java.sql.Timestamp. (System/currentTimeMillis))))

(defn all []
  (j/query mysql-db
    (s/select * :car)))