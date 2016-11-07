(ns ebtanas.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [ebtanas.core-test]
   [ebtanas.common-test]))

(enable-console-print!)

(doo-tests 'ebtanas.core-test
           'ebtanas.common-test)
