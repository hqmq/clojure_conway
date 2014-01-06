(ns conway.parse
  (:require [clojure.string :as str ]))

(defn character-to-cell [char]
  (cond
    (= char \o) :alive
    :else :dead))

(defn cell-to-character [cell]
  (cond
    (= cell :alive) \o
    :else \.))

(defn parse [board_string]
  (vec (map (fn [line]
    (vec (map character-to-cell line)))
      (str/split-lines board_string))))

(defn render [grid]
  (str/join "\n"
    (map (fn [row]
      (apply str (map cell-to-character row)))
      grid)))
