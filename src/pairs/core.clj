(ns pairs.core
  (:use [clojure.math.combinatorics :only [combinations]])
  (:gen-class))

(def pairs {"P" 0 "A" 0 "I" 0 "R" 0 "S" 0 })
(def pairs-order {"P" 5 "A" 4 "I" 3 "R" 2 "S" 1})

(defn sort-pairs-map [results]
  "Sort map to a correct PAIRS (tm) order"
  (into (sorted-map-by (fn [key1 key2]
                         (compare (get pairs-order key2)
                                  (get pairs-order key1))))
        results))

(defn count-pairs-chars [name1 name2]
  "Counts PAIRS (tm) character counts in two strings. Returns a vector because we like to use conj later to append to the collection."
  (vec (vals (sort-pairs-map (reduce #(if (contains? %1 %2) (assoc %1 %2 (inc (%1 %2 0))) %1) pairs (map clojure.string/upper-case (str name1 name2)))))))

(defn split-number [num]
  "Splits an integer to a list of digits"
  (map #(Integer/parseInt (str %)) (seq (str num))))

(defn count-sum [first-val second-val]
  "Sums two numbers together in the PAIRS (tm) way. If the sum is 10 or greater returns the sum of the digits in the result
  e.g. (count-sum 5 7) will return 3 (5 + 7 = 12 -> 1+2 = 3)"
  (let [sum (+ first-val second-val)]
    (if (>= sum 10)
        (apply count-sum (split-number sum))
      sum)))

(defn count-list [numbers-vector]
  "Returns a new iteration of PAIRS (tm) values"
  (loop [coll numbers-vector acc []]
    (if (< (count coll) 2)
      acc
      (recur (rest coll) (conj acc (count-sum (first coll) (second coll)))))))

(defn get-pairs-count [name1 name2]
  "Returns PAIRS (tm) percent as an integer for name1 and name2"
  (loop [coll (count-pairs-chars name1 name2)]
    (if (< (count coll) 3)
       (Integer/parseInt (apply str coll))
      (recur (count-list coll)))))

(defn print-pairs-percent [two-names]
  "Prints PAIRS (tm) percent as integer for name1 and name2"
  (let [name1 (first two-names)
        name2 (second two-names)
        pairs-value (get-pairs-count name1 name2)]
      (println (format "PAIRS (tm) compatibility percent for \"%s\" and \"%s\" is %s%%" name1 name2 pairs-value))))

(defn is-perfect-match [two-names]
  (let [name1 (first two-names)
        name2 (second two-names)
        pairs-value (get-pairs-count name1 name2)]
    (= pairs-value 99)))

(defn -main
  [& args]
  (let [name-list (clojure.string/split (slurp (.getPath (clojure.java.io/resource "fast_track_generoitu_nimilista.txt"))) #"\n")
        name-combinations (clojure.math.combinatorics/combinations name-list 2)]
;;     (doall (map print-pairs-percent name-combinations)))
    (println (format "%d perfect PAIRS (tm) matches" (count (filter true? (map is-perfect-match name-combinations)))))))
