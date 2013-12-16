(ns starman.main
  (:use [clojure.tools.cli :only (cli)]
        [clojure.pprint])
  (:gen-class :main true)
  (:require
            [pallet.api :refer [group-spec server-spec node-spec plan-fn converge lift]]
            [pallet.java.example.pallet :as pax]
            [pallet.compute :refer [nodes images]]
            [clojure.pprint :refer [pprint]]
            [pallet.compute.vmfest :refer [add-image]]
            [pallet.node :refer [group-name primary-ip]]
            [pallet.phase :as pphase]
            [pallet.actions :as pact]
            [clojure.java.io :as io]
            [pallet-java-example.groups.pallet-java-example :as pvm]
            [clojure.java.shell :as csh]))


;; Simple example showing creatin of a compute service provider, via vmfest
;; and the converge of it
;; Note you'll have to shut down the VM manually in this example
(defn -main [& args]
  (do
    (pvm/init-vmfest)
    ((converge {pvm/example-group 1} :compute (:vmfest @pvm/provider))
      (System/exit 0))
    ))

