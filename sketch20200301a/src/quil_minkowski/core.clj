(ns quil-minkowski.core
  (:require [quil.core :as q]
            [tyrion.distance :as distance]))

(def W 500)
(def HALF-W (* 0.5 W))

(defn normalize [x]
  (let [step (quot HALF-W 10)]
    (* step (quot x step))))

(defn setup []
  (q/no-loop))

(defn draw []
  (doseq [y (range W)
          x (range W)
          :let [dist (distance/minkowski [HALF-W HALF-W] [x y] 3)
                gray (normalize (* 255 (/ dist W)))]]
    (q/stroke gray)
    (q/stroke-weight 1)
    (q/point x y)))

(q/defsketch quil-minkowski
  :title "draw minkowski distance"
  :size [W W]
  :setup setup
  :draw draw
  :features [:keep-on-top])

(defn -main [])
