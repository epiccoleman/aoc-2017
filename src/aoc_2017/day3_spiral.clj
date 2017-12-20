(ns aoc-2017.day3-spiral)

(defn rung-from-center [n]
  (->> (Math/sqrt n)
       (Math/ceil)
       (#(- % 2))))
