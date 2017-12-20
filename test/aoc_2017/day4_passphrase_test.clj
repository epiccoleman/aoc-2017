(ns aoc-2017.day4-passphrase-test
  (:require [clojure.test :refer :all]
            [aoc-2017.day4-passphrase :refer :all]))

;; To ensure security, a valid passphrase must contain no duplicate words.

;; For example:

;; aa bb cc dd ee is valid.
;; aa bb cc dd aa is not valid - the word aa appears more than once.
;; aa bb cc dd aaa is valid - aa and aaa count as different words.

(deftest passphrase->word-seq-test
  (is (= (passphrase->word-seq "aaa bbb ccc") '("aaa" "bbb" "ccc"))))


(deftest passphrase-valid?-test
  (is (passphrase-valid? "aa bb cc dd ee"))
  (is (passphrase-valid? "aa bb cc dd aaa"))
  (is (not (passphrase-valid? "aa bb cc dd aa"))))
