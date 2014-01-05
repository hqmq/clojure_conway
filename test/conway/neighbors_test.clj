(ns conway.neighbors-test
  (:require [clojure.test :refer :all]
            [conway.neighbors :refer :all]))

(def grid1 [[:dead  :dead  :dead ]
            [:alive :dead  :dead ]
            [:alive :alive :dead ]
            [:alive :alive :alive]])

(def neighbors1 [[1 1 0]
                 [2 3 1]
                 [4 5 3]
                 [3 4 2]])

(deftest neighbors-test
  (testing "Counts neighbors"
    (is (= neighbors1 (neighbor-grid grid1)))))
