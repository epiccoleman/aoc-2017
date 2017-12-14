(ns aoc-2017.day2-spreadsheet-test
  (:require [clojure.test :refer :all]
            [aoc-2017.day2-spreadsheet :refer :all]))

(deftest string->number-vec-test
  (is (= (string->number-vec "10 18 1991 90125") [10 18 1991 90125])))

(deftest difference-for-coll-test
  (is (= (difference-for-coll [10 18 1991]) 1981)))

(deftest solve-spreadsheet-1-test
  (is (= (solve-spreadsheet-1 '((5 1 9 5)
                                (7 5 3)
                                (2 4 6 8)))
         18)))

(deftest divide-line-test
  (is (= (divide-line '(5 9 2 8)) 4))
  (is (= (divide-line '(9 4 7 3)) 3))
  (is (= (divide-line '(3 8 6 5)) 2)))

(deftest solve-spreadsheet-2-test
  (is (= (solve-spreadsheet-2 '((5 9 2 8)
                                (9 4 7 3)
                                (3 8 6 5)))
         9)))
