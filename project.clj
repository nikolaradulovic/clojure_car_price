(defproject blog "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [org.clojure/java.jdbc "0.3.0-alpha5"]
                 [mysql/mysql-connector-java "5.1.25"]
                 [de.ubercode.clostache/clostache "1.3.1"]
                 [org.clojure/data.csv "0.1.3"]
                 [incanter "1.5.6"]
                 [ring-basic-authentication "1.0.2"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler clojure_car_price.core/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
