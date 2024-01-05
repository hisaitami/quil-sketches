(ns sketch20200116a.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  (q/frame-rate 24)
  {:counter 0.0})

(defn update-state [state]
  {:counter (+ (:counter state) 0.1)})

(defn draw-state [state]
  (q/background 0)
  (q/fill 0)
  (q/stroke 255)
  (doseq [s (range (q/width) 0 -8)
          :let [x (* 0.5 (q/width))
                y (* 0.5 (q/height))
                a (q/sin (- (:counter state) (/ s 48)))
                b (* q/TWO-PI a)]]
      (q/arc x y s s 0 b)
      (q/arc x y s s a 0)))

(q/defsketch sketch20200116a
  :title "sketch20200116a"
  :size [500 500]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
