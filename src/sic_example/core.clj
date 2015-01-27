(ns sic-example.core
  (:require [grafter.rdf.protocols :as pr]
            [grafter.rdf.io :as io]
            [sic-example.pipeline :refer :all]
            [sic-example.template :refer :all]))

(defn in-quad?
  [value quad]
  (some true?
        (map #(= value %)
             [(pr/subject quad)
              (pr/predicate quad)
              (pr/object quad)
              (pr/context quad)])))

(defn strike-nils
  [quads]
  (remove (fn [quad] (or (in-quad? "nil" quad)
                        (in-quad? nil quad)))
          quads))

(defn write-to-ttl
  [quads destination]
  (let [validated-quads (strike-nils quads)]
    (pr/add (io/rdf-serializer destination) validated-quads)))

(defn -main [path output]
  (-> (sic-pipeline path)
      sic-template
      (write-to-ttl output)))
