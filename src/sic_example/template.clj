(ns sic-example.template
  (:require [grafter.rdf.templater :refer :all]
            [grafter.rdf :refer :all]
            [grafter.tabular :refer :all]
            [grafter.rdf.ontologies.rdf :refer :all]
            [sic-example.ontology :refer :all]
            [sic-example.utils :refer :all]))

(def sic-template
  (graph-fn [[section section-label division division-label group group-label class class-label sub-class sub-class-label]]
            (graph sic-graph-uri
                   [(uriify-sic-code section)
                    [rdf:a sic:Section]
                    [rdfs:label (s section-label)]
                    [sic:code (s (clojure.string/replace section #" " ""))]])

            (graph sic-graph-uri
                   [(uriify-sic-code division)
                    [rdf:a sic:Division]
                    [rdfs:label (s division-label)]
                    [sic:code (s division)]])
            
            (graph sic-graph-uri
                   [(uriify-sic-code group)
                    [rdf:a sic:Group]
                    [rdfs:label (s group-label)]
                    [sic:code (s group)]])
            
            (graph sic-graph-uri
                   [(uriify-sic-code class)
                    [rdf:a sic:Class]
                    [rdfs:label (s class-label)]
                    [sic:code (s class)]])
            
            (graph sic-graph-uri
                   [(uriify-sic-code sub-class)
                    [rdf:a sic:SubClass]
                    [rdfs:label (s sub-class-label)]
                    [sic:code (s sub-class)]])))

