(ns conway.parse
  (:require [clojure.string :as str ]))

(defn character-to-cell [char]
  (cond
    (= char \o) :alive
    :else :dead))

(defn parse [board_string]
  (vec (map (fn [line]
    (vec (map character-to-cell line)))
      (str/split-lines board_string))))
