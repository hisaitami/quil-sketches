(ns quil-minkowski.core
  (:require [quil.core :as q]
            [tyrion.distance :as distance]))

(def width 500)

(def half-width (* 0.5 width))

(def step (quot half-width 10))

(defn dist [x y]
  (distance/minkowski [half-width half-width] [x y] 3))

(defn gray [dist]
  (int (* 255 (/ dist width))))

(defn setup []
  (q/no-loop))

(defn draw []
  (doseq [y (range width)
          x (range width)]
    (q/stroke (* step (quot (gray (dist x y)) step)))
    (q/stroke-weight 1)
    (q/point x y)))

(q/defsketch quil-minkowski
  :title "draw minkowski distance"
  :size [width width]
  :setup setup
  :draw draw
  :features [:keep-on-top])
