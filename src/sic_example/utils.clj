(ns sic-example.utils
  (:require [sic-example.ontology :refer :all]))

;; some utility functions to aid in the templating effort.

(def not-nil? (complement nil?))

(defn uriify-sic-code
  [sic-code]
  (-> sic-code
      (clojure.string/replace #"\.| |\/" "")
      sic-resource))

