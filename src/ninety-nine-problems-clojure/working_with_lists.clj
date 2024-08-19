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
  [coll]
  (reverse-list-aux coll '()))

(defn ^:private reverse-list-aux
  [coll out]
  (let [head (first coll)
        tail (rest coll)
        *out* (conj out head)]
    (cond
      (empty? coll) out
      :else (reverse-list-aux tail *out*))))

(defn flatten-list
  "Flattens a collection"
  [coll]
  (flatten-list-aux coll '()))

(defn ^:private flatten-list-aux
  [coll out]
  (let [head (first coll)
        tail (rest coll)]
    (cond
      (empty? coll) out
      (false? (coll? head)) (conj (flatten-list-aux tail out) head)
      (coll? head) (flatten-list-aux head (flatten-list-aux tail out)))))

(flatten-list '(:a :b :c :d :e))
(flatten-list '(:a :b :c :d (:e (:d :e (:f)))))
