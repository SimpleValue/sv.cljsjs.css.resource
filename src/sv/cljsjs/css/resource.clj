(ns sv.cljsjs.css.resource
  (:require [clojure.java.classpath :as cp]
            [clojure.java.io :as io]
            [ring.util.response :as resp]))

(defn cljsjs-css-files* []
  (filter
   #(and (.startsWith % "cljsjs/") (.endsWith % ".css"))
   (mapcat
    #(cp/filenames-in-jar %)
    (cp/classpath-jarfiles))))

(def cljsjs-css-files (memoize cljsjs-css-files*))

(defn cljsjs-css []
  (apply
   str
   (map
    (fn [file-path]
      (slurp (io/resource file-path)))
    (cljsjs-css-files))))

(defn cljsjs-css-resource
  [request]
  ;; TODO: add appropriate cache headers
  (when (and (= (:request-method request) :get)
             (= (:uri request) (str "/css/cljsjs.css")))
    (resp/content-type
     (resp/response
      (cljsjs-css))
     "text/css")))
