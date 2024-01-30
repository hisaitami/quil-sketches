(ns iced-rebel
  "NOTE: This code is borrowed from the vim-iced document.
  see https://github.com/liquidz/vim-iced

  If you use Rebel Readline or want to embed an nREPL in your application,
  then one approach is to create a `user.clj` with the following:

  Start the Rebel Readline REPL and from it's prompt start the nREPL server
  using `start-nrepl-server!`, then in Vim do `:IcedConnect`.
  "
  (:require [nrepl.server :as nrepl-server]
            [clojure.java.io :as io]))

(def nrepl-port 7888)
(defonce nrepl-server (atom nil))

(defn cider-middleware
  "Get cider middleware, see
  https://github.com/clojure-emacs/cider-nrepl/issues/447"
  []
  (require 'cider.nrepl)
  (map ns-resolve
       ['cider.nrepl 'cider.nrepl 'cider.nrepl 'cider.nrepl 'cider.nrepl 'cider.nrepl 'cider.nrepl 'cider.nrepl 'cider.nrepl 'cider.nrepl 'cider.nrepl 'cider.nrepl 'cider.nrepl 'cider.nrepl]
       ['wrap-classpath 'wrap-clojuredocs 'wrap-complete 'wrap-debug 'wrap-format 'wrap-info 'wrap-macroexpand 'wrap-ns 'wrap-out 'wrap-refresh 'wrap-stacktrace 'wrap-spec 'wrap-test 'wrap-trace 'wrap-undef 'wrap-xref]))

(defn dev-middleware []
  (mapcat (fn [[ns syms]] (require ns) (map (partial ns-resolve ns) syms))
          [['refactor-nrepl.middleware ['wrap-refactor]] ['iced.nrepl ['wrap-iced]]]))

(defn nrepl-handler
  "Re-implement cider-nrepl-handler so we can add middleware to the default list"
  []
  (apply nrepl-server/default-handler (concat (cider-middleware) (dev-middleware))))

(defn start-nrepl-server! []
  (reset!
    nrepl-server
    (nrepl-server/start-server :port nrepl-port :handler (nrepl-handler)))
  (println "Cider nREPL server started on port" nrepl-port)
  (spit ".nrepl-port" nrepl-port))

(defn stop-nrepl-server! []
  (when (not (nil? @nrepl-server))
    (nrepl-server/stop-server @nrepl-server)
    (println "Cider nREPL server on port" nrepl-port "stopped")
    (reset! nrepl-server nil)
    (io/delete-file ".nrepl-port" true)
    (System/exit 0)))
