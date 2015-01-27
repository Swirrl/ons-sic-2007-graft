(ns sic-example.pipeline
  (:require [grafter.tabular :refer :all]
            [grafter.sequences :refer :all]
            [clojure.string :refer [blank?]]))

(def not-blank? (complement blank?))

(defpipe sic-pipeline
  "Performs transformations on the first page of the SIC Excel file"
  [file]
  (-> file
      read-dataset
      (make-dataset [:section :section-label
                     :division :division-label
                     :group :group-label
                     :class :class-label
                     :sub-class :sub-class-label])
      (drop-rows 2)
      (apply-columns {:section fill-when :section-label fill-when
                      :division #(fill-when not-blank? % "01")
                      :division-label #(fill-when not-blank? % "Crop and animal production, hunting and related service activities")
                      :group #(fill-when not-blank? % "01.1")
                      :group-label #(fill-when not-blank? % "Growing of non-perennial crops")
                      :class #(fill-when not-blank? % "01.11")
                      :class-label #(fill-when not-blank? % "Growing of cereals (except rice), leguminous crops and oil seeds")
                      :sub-class #(fill-when not-blank? % "01.62/1")
                      :sub-class-label #(fill-when not-blank? % "Farm animal boarding and care")})))
