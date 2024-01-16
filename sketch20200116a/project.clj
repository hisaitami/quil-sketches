(defproject sketch20200116a "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/hisaitami/quil-sketches"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [quil "4.3.1323"]]
  :profiles {:dev {:dependencies [[com.bhauman/rebel-readline "0.1.4"]
                                  [nrepl/nrepl "1.1.0"]
                                  [refactor-nrepl/refactor-nrepl "3.9.1"]
                                  [cider/cider-nrepl "0.44.0"]
                                  [com.github.liquidz/iced-nrepl "1.2.480"]]
                   :aliases {"rebel" ["trampoline" "run" "-m" "rebel-readline.main"]}}})
