;; Define a function that filters even numbers and doubles them
(defn double-evens [numbers]
  (->> numbers
       (filter even?)
       (map #(* % 2))))

;; Execute function on a vector
(double-evens [1 2 3 4 5 6]) ; Returns: (4 8 12)
