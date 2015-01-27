(ns sic-example.ontology
  (:require [grafter.rdf.ontologies.util :refer :all]))

;; graph uri

(def sic-graph-uri "http://swirrl.com/graph/sic")

;; ontology

(def sic (prefixer "http://swirrl.com/def/sic/"))

(def sic:Section (sic "Section"))

(def sic:Division (sic "Division"))

(def sic:Group (sic "Group"))

(def sic:Class (sic "Class"))

(def sic:SubClass (sic "SubClass"))

(def sic:code (sic "code"))

;; resource prefixer

(def sic-resource (prefixer "http://swirrl.com/id/sic/"))

