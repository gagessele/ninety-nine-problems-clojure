(ns working-with-lists-test
  (:require [clojure.test :refer :all]
            [working-with-lists :as wwl]))

(deftest p01
  (testing "Find the last box of a list"
    (is (= '(:d)
           (wwl/last-box '(:a :b :c :d))))))

(deftest p02
  (testing "Find the last but one box of a list"
    (is (= '(:c :d)
           (wwl/last-but-one-box '(:a :b :c :d))))))

(deftest p03
  (testing "Find the K'th element of a list"
    (is (= :c
           (wwl/element-at '(:a :b :c :d :e) 3)))
    (is (= :c
           (nth '(:a :b :c :d :e) 2)))))

(deftest p07
  (testing "Flatten a nested list structure"
    (is (= '(:a :b :c :d :e)
           (flatten (list :a (list :b (list :c :d) :e)))))))
