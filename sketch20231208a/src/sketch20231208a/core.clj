(ns sketch20231208a.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [clj.qrgen :as qrgen]))

(def qrtxt (ref "hello world"))
(def qrimg (ref nil))

(defn setup []
  (q/frame-rate 30)
  (dosync
   (ref-set qrimg (q/load-image
                    (-> @qrtxt
                        (qrgen/from :size [(q/width) (q/height)])
                        (qrgen/as-file))))))

(defn draw-state [state]
  ;(q/background 232)
  ;(q/background 22)
  (q/background 211 233 234)
  ;(q/no-stroke)
  (doseq [[x y _] (for [x (range 0 (q/width) 5)
                        y (range 0 (q/height) 5)
                        :let [c (q/get-pixel @qrimg x y)]
                        :when (not= c -1)]
                    [x y c])]

    (comment
      ;take 1
      ; background 232
      ; no-stroke
      (q/fill 112 0 0)
      (q/rect x y 5 5))

    (comment
      ; take 2
      ; background 22
      ; no-stroke
      (q/fill 112 0 0)
      (q/rect x y 5 5)
      (q/ellipse x y (rand-int 10) (rand-int 30)))

    (comment
      ; take 3
      ; background 22
      ; no-stroke
      (q/fill 112 0 0)
      (q/rect x y 5 5)
      (q/fill (+ 100 (rand-int 80)) 0 0)
      (q/ellipse x y (rand-int 10) (rand-int 30)))

    (comment
      ; take 4
      ; background 22
      ; no-stroke
      (q/fill 112 0 0)
      (q/rect x y 5 5)
      (q/fill (+ 100 (rand-int 80)) 0 0)
      (q/ellipse x y (rand-int 10) (rand-int 30))
      (q/fill 240 140 20)
      (q/ellipse x y (rand-int 10) (rand-int 10)))

    (comment
      ; take 5
      ; background 22
      ; stroke
      (q/fill (+ 100 (rand-int 80)) 0 0)
      (q/ellipse x y (rand-int 30) (rand-int 30)))

    (comment
      ; take 6
      ; background 22
      ; stroke
      (q/fill (+ 100 (rand-int 80)) 0 0)
      (q/ellipse x y 10 10)
      (q/fill 0 (+ 100 (rand-int 80)) 130)
      (q/ellipse x y (rand-int 20) (rand-int 20)))

    ; take 7
    ; background 211 233 234
    (q/stroke 0)
    (q/fill (+ 100 (rand-int 80)) 0 0)
    (q/ellipse x y 10 10)
    (q/fill 0 (+ 100 (rand-int 80)) 130)
    (q/ellipse x y (rand-int 20) (rand-int 20))
    (q/no-stroke)
    (let [r (mod x 4)]
      (q/fill (+ 200 (rand-int 55)) 255 255)
      (q/ellipse (+ (- x 60) (rand-int 120)) (+ (- y 60) (rand-int 120)) r r))

    ))

(q/defsketch sketch20231208a
  :title "hello world in QRcode"
  :size [500 500]
  :setup setup
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
