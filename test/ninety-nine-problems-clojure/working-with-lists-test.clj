(ns working-with-lists-test
  (:require [clojure.test :refer :all]
            [working-with-lists :as wlw]))

(deftest p01
  (testing "Find the last box of a list"
    (is (= '(d)
           (wlw/last-box '(a b c d))))))
