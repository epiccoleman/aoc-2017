(ns aoc-2017.day4-passphrase
  (:require [aoc-2017.aoc-util :as util]
            [clojure.string :as string]))

(defn passphrase->word-seq [passphrase]
  (seq (string/split passphrase #"\s")))

(defn passphrase-valid? [passphrase-seq]
    (= (distinct passphrase-seq) passphrase-seq))

(defn count-valid-passphrases []
  (->> (util/process-file-with "day4-input" str)
       (map passphrase->word-seq)
       (filter passphrase-valid?)
       (count)))

;; (count-valid-passphrases)
