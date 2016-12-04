(defproject ebtanas "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main ebtanas.core

  :dependencies [[org.clojure/clojure "1.8.0"]
                 ;; server
                 [ring/ring-jetty-adapter "1.5.0"]
                 [metosin/ring-http-response "0.8.0"]

                 ;; midleware
                 [ring/ring-devel "1.5.0"]] ;; ring.middleware.reload

  :source-paths ["src/clj" "src/cljc" "src/cljs"]
  :resource-paths ["resources"])
