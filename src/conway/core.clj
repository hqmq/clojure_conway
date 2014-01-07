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
  (def generation (atom 1))
  (def changed (atom true))
  (while (not (not @changed))
    (do
      (clear-screen)
      (.println (System/out) (parse/render @grid))
      (.println (System/out) (format "Generation: %6d" @generation))
      (def next_grid (gen/next-gen @grid))
      (reset! changed (not (= next_grid @grid)))
      (reset! grid next_grid)
      (swap! generation inc)
      (Thread/sleep 50))))
