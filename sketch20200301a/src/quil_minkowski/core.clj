(ns quil-minkowski.core
  (:require [quil.core :as q]
            [tyrion.distance :as distance]))

(def size 500)

(def half-size (* 0.5 size))

(defn setup []
  (q/no-loop))

(defn draw []
  (doseq [y (range size)
          x (range size)
          :let [dist (distance/minkowski [half-size half-size] [x y] 3)
                gray (int (* 255 (/ dist size)))
                step (quot half-size 10)]]
    (q/stroke (* step (quot gray step)))
    (q/stroke-weight 1)
    (q/point x y)))

(q/defsketch quil-minkowski
  :title "draw minkowski distance"
  :size [size size]
  :setup setup
  :draw draw
  :features [:keep-on-top])
