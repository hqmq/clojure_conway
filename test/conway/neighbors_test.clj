(ns conway.neighbors-test
  (:require [clojure.test :refer :all]
            [conway.neighbors :as neighbs]))

(def grid1 [[:dead  :dead  :dead ]
            [:alive :dead  :dead ]
            [:alive :alive :dead ]
            [:alive :alive :alive]])

(def neighbors1 [[1 1 0]
                 [2 3 1]
                 [4 5 3]
                 [3 4 2]])

(def grid-with-neighbors [[[:dead  1] [:dead  1] [:dead  0]]
                          [[:alive 2] [:dead  3] [:dead  1]]
                          [[:alive 4] [:alive 5] [:dead  3]]
                          [[:alive 3] [:alive 4] [:alive 2]]])

(deftest neighbors-test
  (testing "Counts neighbors"
    (is (= neighbors1 (neighbs/grid-count grid1))))
  (testing "Cells with neighbor counts"
    (is (= grid-with-neighbors (neighbs/grid-with-counts grid1)))))
