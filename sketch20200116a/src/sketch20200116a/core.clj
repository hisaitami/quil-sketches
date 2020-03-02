(ns sketch20200116a.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  (q/frame-rate 24)
  {:counter 0})

(defn update-state [state]
  {:counter (+ (:counter state) 0.1)})

(defn draw-state [state]
  (q/background 0)
  (q/fill 0)
  (q/stroke 255)

  (doseq [i (range (q/width) 0 -8)]
    (let [p (/ (q/width) 2)
          a (q/sin (- (:counter state) (/ i 48)))]
      (q/arc p p i i 0 (* q/PI 2 a))
      (q/arc p p i i a 0))))

(q/defsketch sketch20200116a
  :title "sketch20200116a"
  :size [500 500]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
