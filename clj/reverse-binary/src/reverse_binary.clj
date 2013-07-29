(ns reverse-binary
  (:require [clojure.math.numeric-tower :as nt]))

(defn reverse-binary [x]
  (let [n (int (nt/ceil (/ (Math/log (+ x 1)) (Math/log 2))))]
    (loop [x x result 0 i 1]
      (if (or (zero? x) (= x 1))
        (+ result x)
        (recur (quot x 2) (int (+ result (* (rem x 2) (Math/pow 2 (- n i))))) (inc i))))))

(defn -main [& args]
  (doseq [line (line-seq (java.io.BufferedReader. *in*))] 
    (println (reverse-binary (read-string line)))))

