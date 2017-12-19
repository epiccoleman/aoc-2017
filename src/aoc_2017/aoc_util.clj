(ns aoc-2017.aoc-util
  (:require [clojure.java.io :as io]))

  ;; http://clojure-doc.org/articles/cookbooks/files_and_directories.html
  (defn process-file-with [filename f]
    (with-open [rdr (io/reader (io/resource filename))]
      (doall (map f (line-seq rdr)))))
