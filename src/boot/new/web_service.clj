(ns boot.new.web-service
  (:require [clojure.string :as str]
            [boot.new.templates :as b]))

(def render (b/renderer "web-service"))

(defn make-label
  "Capitalize every word in a string"
  [s]
  (->> (str/split (str s) #"-")
       (map str/capitalize)
       (str/join " ")))

(defn web-service
  "Creates a minimal web service."
  [name]
  (let [ns name
        data {:name name
              :path (b/name-to-path name)
              :ns ns
              :label (make-label name)}]
    (println "Creating web service:" name)
    (b/->files data
               ["build.boot" (render "build.boot" data)]
               ["src/{{path}}/core.clj" (render "core.clj" data)]
               ["src/{{path}}/config.clj" (render "config.clj" data)]
               ["src/{{path}}/meta.clj" (render "meta.clj" data)]
               ["src/{{path}}/web/api.clj" (render "web/api.clj" data)]
               ["src/{{path}}/web/server.clj" (render "web/server.clj" data)]
               ["config/config.edn" (render "config.edn" data)]
               ["test/{{path}}/core_test.clj" (render "core_test.clj" data)])))

