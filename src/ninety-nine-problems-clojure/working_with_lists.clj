(ns working-with-lists)

(defn last-box
  "Find the last box of a list."
  [coll]
  (let [xs (rest coll)]
    (cond
      (empty? xs) coll
      :else (last-box xs))))

(defn last-but-one-box
  "Find the last but one box of a list"
  [coll]
  (let [[x1 x2 & xs] coll]
    (cond
      (empty? coll) ()
      (nil? x2) (list x1)
      (nil? xs) (list x1 x2)
      :else (recur (last-but-one-box xs)))))

(defn element-at
  [coll i]
  (cond
    (= 1 i) (first coll)
    :else (element-at (rest coll) (- i 1))))
