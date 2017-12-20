(ns aoc-2017.day4-passphrase
  (:require [aoc-2017.aoc-util :as util]
            [clojure.string :as string]))

(defn passphrase->word-seq [passphrase]
  (seq (string/split passphrase #"\s")))

(defn passphrase-valid? [passphrase]
  (let [passphrase-seq (passphrase->word-seq passphrase)]
    (= (distinct passphrase-seq) passphrase-seq)))

(defn count-valid-passphrases []
  (->> (util/process-file-with "day4-input" str)
       (filter passphrase-valid?)
       (count)))

;; (count-valid-passphrases)

(defn is-anagram? [])
