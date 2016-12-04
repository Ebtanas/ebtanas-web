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
                 [ring/ring-devel "1.5.0"]] ;; ring.middleware.reload

  :source-paths ["src/clj" "src/cljc" "src/cljs"]
  :resource-paths ["resources" "target/cljsbuild"]

  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-figwheel "0.5.8"]]

  :figwheel {:http-server-root "public"
             :css-dirs ["resources/public/css"]
             :ring-handler ebtanas.core/handler}

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/cljs" "src/cljc"]
                        :figwheel true
                        :compiler {:output-to "target/cljsbuild/public/js/app.js"
                                   :output-dir "target/cljsbuild/public/js/out"
                                   :source-map true
                                   :pretty-print true}}
                       {:id "min"
                        :source-paths ["src/cljs" "src/cljc"]
                        :compiler {:output-to "resources/public/js/app.js"
                                   :output-dir "resources/public/js/out"
                                   :pretty-print false
                                   :optimizations :advanced}}]}

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"])



