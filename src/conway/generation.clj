(ns conway.generation
  (:require [conway.neighbors :as neighbs]))

(defn next-gen-cell [current, neighbors]
  (cond
    (and (= current :alive) (or (= neighbors 2) (= neighbors 3))) :alive
    (and (= current :dead) (= neighbors 3)) :alive
    :else :dead))

(defn next-gen [grid]
  (vec (map (fn [row]
    (vec (map (fn [cell] (next-gen-cell (first cell) (last cell)))
    row)))
  (neighbs/grid-with-counts grid))))
