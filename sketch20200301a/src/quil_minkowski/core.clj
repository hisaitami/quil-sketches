(ns quil-minkowski.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [tyrion.distance :as distance]))

(defn setup []
  (q/frame-rate 1))

(defn draw-state [state]
  ;(q/background 255)
  (let [half-width 250
        width (* half-width 2)
        dist (fn [x y] (distance/minkowski [half-width half-width] [x y] 3))
        gray (fn [dist] (int (* 255 (/ dist width))))
        step (quot half-width 10)]
    (dotimes [y width]
      (dotimes [x width]
        (q/stroke (* step (quot (gray (dist x y)) step)))
        (q/stroke-weight 1)
        (q/point x y)))))

(q/defsketch quil-minkowski
  :title "draw minkowski distance"
  :size [500 500]
  :setup setup
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
