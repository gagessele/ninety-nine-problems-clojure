(ns working-with-lists)

(defn last-box
  "Find the last box of a list."
  [coll]
  (let [[x & xs] coll]
    (println x xs)
    (cond
      (nil? xs) coll)))
