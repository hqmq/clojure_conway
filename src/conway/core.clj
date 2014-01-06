(ns conway.core
  (:require [clojure.java.io :as io])
  (:gen-class))

(defn clear-screen []
  (.print (System/out) (str "\033[" "2J" "\r")))

(defn -main [board_file]
  (while true
    (clear-screen)
    (.print (System/out)
      (slurp (io/reader (io/file board_file))))
    (Thread/sleep 300)))
