(defproject sv/cljsjs.css.resource "0.1.0-SNAPSHOT"
  :description "A Ring handler that provides all cljsjs css files in
                the classpath as a single resource under the path
                '/css/cljsjs.css'."
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [ring/ring-core "1.4.0"]
                 [org.clojure/java.classpath "0.2.3"]])
