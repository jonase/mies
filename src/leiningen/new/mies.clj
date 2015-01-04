(ns leiningen.new.mies
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]))

(def render (renderer "mies"))

(defn mies [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
      ["project.clj" (render "project.clj" data)]
      ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)]
      ["index.html" (render "index.html" data)]
      ["README.md" (render "README.md" data)]
      [".gitignore" (render "gitignore" data)]
      ["scripts/compile_cljsc" (render "compile_cljsc" data) :executable true]
      ["scripts/repl" (render "repl" data) :executable true]
      ["scripts/browser_repl" (render "browser_repl" data) :executable true]
      ["scripts/repl.clj" (render "repl.clj" data)]
      ["scripts/browser_repl.clj" (render "browser_repl.clj" data)])))
