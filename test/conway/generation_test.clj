(ns conway.generation-test
  (:require [clojure.test :refer :all]
            [conway.generation :as gen]))

(def grid1 [[:dead  :alive :alive]
            [:alive :dead  :dead ]
            [:dead  :dead  :alive]])

(def grid2 [[:dead  :alive :dead ]
            [:dead  :dead  :alive]
            [:dead  :dead  :dead]])

(deftest generation-test
  (testing "generation rules"
    (is (= grid2 (gen/next-gen grid1)))))
