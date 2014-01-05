(ns conway.parse-test
  (:require [clojure.test :refer :all]
            [conway.parse :as p]))

(def board
"  o  
o o o")

(def grid [[:dead :dead :alive :dead :dead] [:alive :dead :alive :dead :alive]])

(deftest board-parse-test
  (testing "Parsing the intial board string"
    (is (= grid (p/parse board)))))
