(ns aoc-2017.day2-spreadsheet
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

;; file reader stuff
(defn string->number-vec [s]
  (map #(Integer/parseInt %) (string/split s #"\s")))

;; http://clojure-doc.org/articles/cookbooks/files_and_directories.html
(defn seq-of-lines []
  (with-open [rdr (io/reader (io/resource "input"))]
    (doall (map string->number-vec (line-seq rdr)))))


(defn difference-for-coll [coll]
  "Returns difference between max and min number in coll"
  (- (apply max coll) (apply min coll)))

(defn solve-spreadsheet [lines f]
  (reduce + (map f lines)))

(defn solve-spreadsheet-1 [lines]
  (solve-spreadsheet lines difference-for-coll))

(defn divisible-by? [a b] (integer? (/ a b)))

(defn divide-line [line]
  (loop [line (reverse (sort line))]
    (let [divisors (filter #(divisible-by? (first line) %) (rest line))]
      (if (empty? divisors)
        (recur (rest line))
        (/ (first line) (first divisors))))))

(defn solve-spreadsheet-2 [lines]
  (solve-spreadsheet lines divide-line))


;; (solve-spreadsheet-1 (seq-of-lines))  ;; solve the puzzles for aoc
;; (solve-spreadsheet-2 (seq-of-lines))
