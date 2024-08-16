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

(defn number-elements
  "number of elements of a list"
  [coll]
  (let [tail (rest coll)]
    (cond
      (empty? coll) 0
      :else (+ 1 (number-elements tail)))))

(defn reverse-list
  ([coll]
   (cond
     (empty? coll) ()
     :else (let [head (first coll)
                 tail (rest coll)
                 out  (conj '() head)]
             (reverse-list tail out))))
  ([coll out]
   (cond
     (empty? coll) out
     :else (let [head (first coll)
                 tail (rest coll)
                 out (conj out head)]
             (reverse-list tail out)))))

(defn flatten-list
  "Flattens a collection"
  [coll]
  (let [head (first coll)
        tail (rest coll)]
    (println head tail)
    (cond
      (empty? tail) (list head)
      :else (recur (flatten-list (list (flatten-list head) (flatten-list tail)))))))
