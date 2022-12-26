(ns sketch20221223a.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [clj.qrgen :as qrgen]))

(def qrtxt (ref "hello world"))
(def qrimg (ref nil))

(defn setup []
  (q/frame-rate 30)
  ;(q/color-mode :hsb)

  (dosync
   (ref-set qrimg
            (q/load-image
             (-> (qrgen/from @qrtxt :size [(q/width) (q/height)])
                 (qrgen/as-file))))))

(defn draw-state [state]
  (q/background 240)
  (q/no-stroke)
  (doseq [[x y c] (for [x (range 0 (q/width) 5)
                        y (range 0 (q/height) 5)
                        :let [c (q/get-pixel @qrimg x y)]
                        :when (not= c -1)] [x y c])]
    (q/fill 204 102 0)
    (q/ellipse x y 5 5)
    (q/fill (rand-int 250) (rand-int 220) (rand-int 240) (rand-int 200))
    (q/ellipse x y (rand-int 9) (rand-int 9))))

(q/defsketch sketch20221223a
  :title "hello world in QRcode"
  :size [500 500]
  :setup setup
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
