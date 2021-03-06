(ns leiningen.test.javac
  (:use [clojure.test]
        [clojure.java.io :only [file]]
        [leiningen.javac :only [javac]]
        [leiningen.core :only [read-project defproject]]
        [leiningen.util.file :only [delete-file-recursively]]
        [leiningen.test.helper :only [dev-deps-project]]))

(deftest test-javac
  (delete-file-recursively (:compile-path dev-deps-project) true)
  (javac dev-deps-project)
  (is (.exists (file "test_projects/dev-deps-only/classes"
                     "dev_deps_only" "Junk.class"))))
