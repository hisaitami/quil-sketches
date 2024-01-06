(ns quil-minkowski.core
  (:require [quil.core :as q]
            [tyrion.distance :as distance]))

(def size 500)

(def half-size (* 0.5 size))

(def step (quot half-size 10))

(defn normalize [x] (* step (quot x step)))

(defn setup []
  (q/no-loop))

(defn draw []
  (doseq [y (range size)
          x (range size)
          :let [dist (distance/minkowski [half-size half-size] [x y] 3)
                gray (normalize (* 255 (/ dist size)))]]
    (q/stroke gray)
    (q/stroke-weight 1)
    (q/point x y)))

(q/defsketch quil-minkowski
  :title "draw minkowski distance"
  :size [size size]
  :setup setup
  :draw draw
  :features [:keep-on-top])
