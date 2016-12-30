(defproject ebtanas "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main ebtanas.core

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.293"]

                 ;; server
                 [ring/ring-jetty-adapter "1.5.0"]
                 [metosin/ring-http-response "0.8.0"]
                 [compojure "1.5.1"]

                 ;; midleware
                 ;[ring/ring-core "1.5.0"] ;; for logging deps
                                          ;; SLF4J: "org.slf4j.impl.StaticLoggerBinder"
                 [ring/ring-defaults "0.2.1"] ;; ring.middleware.defaults
                 [ring/ring-devel "1.5.0"] ;; ring.middleware.reload
                 ;[ring-middleware-format "0.7.0"]
                 [amalloy/ring-gzip-middleware "0.1.3"] ;; ring.middleware.gzip/wrap-gzip
                 [ring-webjars "0.1.1"] ;; read webjars jars file ; wrap-webjars
                 ;[org.webjars/webjars-locator-jboss-vfs "0.1.0"] ;; webjasrs path locatorlw

                 ;; frontend
                 [hiccup "1.0.5"]
                 [reagent "0.6.0"]
                 ;[reagent-utils "0.2.0"] ; session
                 [org.webjars.npm/spectre.css "0.1.29"]

                 ;; environment
                 [yogthos/config "0.8"] ;; config.core // managing figwheel ns on production
                 ;;[environ "1.1.0"]

                 ;; databases
                 [org.postgresql/postgresql "9.4.1212"]
                 [com.layerware/hugsql "0.4.7"]

                 ;; logger ;; don't know how to config this, just inclide it
                 [ch.qos.logback/logback-classic "1.1.7"]
                 ;[org.slf4j/slf4j-log4j12 "1.7.9"]]

                 ;; test api
                 [metosin/compojure-api "1.2.0-alpha1"]
                 [prismatic/schema "1.1.3"]

                 ;; others
                 [buddy/buddy-hashers "1.1.0"]
                 [bouncer "1.0.0"]
                 [clj-time "0.13.0"]]
                 ;[cljs-ajax "0.5.8"]]

  :source-paths ["src/clj" "src/cljc" "src/cljs" "env"]
  :resource-paths ["resources" "target/cljsbuild"]
  :test-paths ["test"]

  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-figwheel "0.5.8"]]

  :figwheel {:css-dirs ["resources/public/css"]
             :ring-handler ebtanas.core/all-routes}

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/cljs" "src/cljc"]
                        :figwheel true
                        :compiler {:output-to "target/cljsbuild/public/js/compiled/app.js"
                                   :output-dir "target/cljsbuild/public/js/compiled/out"
                                   :source-map true
                                   :pretty-print true
                                   :optimizations :none}}
                       {:id "min"
                        :source-paths ["src/cljs" "src/cljc"]
                        :compiler {:output-dir "resources/public/js/compiled/out"
                                   :pretty-print false
                                   :optimizations :advanced
                                   :modules {:sign-up {:output-to "resources/public/js/compiled/sign_up.js"
                                                       :entries #{"ebtanas.pub.sign-up"}}
                                             :sign-in {:output-to "resources/public/js/compiled/sign_in.js"
                                                       :entries #{"ebtanas.pub.sign-in"}}}}}]}

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :profiles {:dev {:resource-paths ["config/dev"]}
             :min {:resource-paths ["config/min"]}})