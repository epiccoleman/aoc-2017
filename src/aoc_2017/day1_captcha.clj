(ns aoc-2017.day1-captcha)

(defn char->digit [char]
  (Integer/parseInt (str char)))

(defn str->digit-list [str] (map char->digit (seq str)))

(defn first-two-match? [list] (= (first list)
                                 (first (rest list))))

(defn ends-match? [list] (= (first list) (last list)))

(defn captcha-count-pair [list]
  (if (first-two-match? list)
    (first list)
    0))

(defn captcha-count-to-end [captcha-str]
  (loop [captcha-list (str->digit-list captcha-str)
         result 0]
    (if (<= 2 (count captcha-list))
      (recur (rest captcha-list)
             (+ result (captcha-count-pair captcha-list)))
      result)))

(defn captcha-count-last-element [captcha-str]
  (let [captcha-list (str->digit-list captcha-str)]
    (if (ends-match? captcha-list)
      (last captcha-list)
      0)))

(defn captcha-solve [captcha-str]
  (+ (captcha-count-to-end captcha-str)
     (captcha-count-last-element captcha-str)))

;; stole this from https://groups.google.com/forum/#!topic/clojure/SjmevTjZPcQ
;; don't really understand why it works better than mine did.
(defn rotate
  "Take a collection and left rotates it n steps. If n is negative,
the
collection is rotated right. Executes in O(n) time."
  [n coll]
  (let [c (count coll)]
    (take c (drop (mod n c) (cycle coll)))))

(defn rotate-list-left [l]
  (rotate 1 l))

;; my version, seemingly slower than the other
;; reimplemented this to call the other guy
;; (defn rotate-list-left [l]
;;   (concat
;;    (rest l)
;;    (list (first l))))

(defn n-ahead-matches? [list n]
  (= (first list)
     (first
      (loop [n n
             list list]
        (if (< 0 n)
          (recur (dec n) (rotate-list-left list))
          list)))))

(defn captcha-solve-2 [captcha-str]
  (let [captcha-list (str->digit-list captcha-str)
        list-length (count captcha-list)
        distance (/ list-length 2)]
    (loop [i list-length
           current-list captcha-list
           result 0]
      (if (< 0 i)
        (recur (dec i)
               (rotate-list-left current-list)
               (+ result
                   (if (n-ahead-matches? current-list distance)
                     (first current-list)
                     0)
                   ))
        result))))
