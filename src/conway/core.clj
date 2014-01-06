(ns conway.core
  (:require [clojure.java.io :as io]
            [conway.parse :as parse]
            [conway.generation :as gen])
  (:gen-class))

(defn clear-screen []
  (.print (System/out) (str "\033[2J\033[1;1H")))

(defn -main [board_file]
  (def board (slurp (io/reader (io/file board_file))))
  (def grid (atom (parse/parse board)))
  (while true
    (clear-screen)
    (.print (System/out) (parse/render @grid))
    (swap! grid gen/next-gen)
    (Thread/sleep 300)))
