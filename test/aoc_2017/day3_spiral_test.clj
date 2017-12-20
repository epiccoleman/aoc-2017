(ns aoc-2017.day3-spiral-test
  (:require [clojure.test :refer :all]
            [aoc-2017.day3-spiral :refer :all]))

(deftest rung-from-center-test
  (is (= (rung-from-center 3) 1))
  (is (= (rung-from-center 9) 1))
  (is (= (rung-from-center 11) 2))
  (is (= (rung-from-center 26) 3)))
