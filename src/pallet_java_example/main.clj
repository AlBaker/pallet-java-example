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
            [clojure.java.shell :as csh]))



