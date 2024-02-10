(ns sketch20200116a.core
  (:require [quil.core :as q]))

(def W 500)
(def c (atom 0.0))

(defn setup []
  (q/frame-rate 24))

(defn draw []
  (q/background 0)
  (q/fill 0)
  (q/stroke 255)
  (let [c (swap! c + 0.1)
        x (* 0.5 W)
        y (* 0.5 W)]
    (doseq [s (range W 0 -8)
            :let [a (q/sin (- c (/ s 48)))
                  b (* q/TWO-PI a)]]
      (q/arc x y s s 0 b)
      (q/arc x y s s a 0))))

(q/defsketch sketch20200116a
  :title "sketch20200116a"
  :size [W W]
  :setup setup
  :draw draw
  :features [:keep-on-top])

(defn -main [])
