(ns conway.neighbors)

(defn get-cell-status [grid row_idx col_idx]
  (try
    ((grid row_idx) col_idx)
    (catch IndexOutOfBoundsException e :dead)))

(defn count-neighbors [grid row_idx col_idx]
  (count (filter (fn [c] (= c :alive)) [
    (get-cell-status grid (- row_idx 1) (- col_idx 1))
    (get-cell-status grid (- row_idx 1) col_idx)
    (get-cell-status grid (- row_idx 1) (+ col_idx 1))
    (get-cell-status grid row_idx (- col_idx 1))
    (get-cell-status grid row_idx (+ col_idx 1))
    (get-cell-status grid (+ row_idx 1) (- col_idx 1))
    (get-cell-status grid (+ row_idx 1) col_idx)
    (get-cell-status grid (+ row_idx 1) (+ col_idx 1))])))

(defn neighbor-grid [grid]
  (vec (map-indexed (fn [row_idx, row]
    (vec (map-indexed (fn [col_idx, cell]
      (count-neighbors grid row_idx col_idx))
    row)))
  grid)))
