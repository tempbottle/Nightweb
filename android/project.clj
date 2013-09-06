(defproject nightweb-android/Nightweb "0.0.20"
  :license {:name "Public Domain"
            :url "http://unlicense.org/UNLICENSE"}
  :min-lein-version "2.0.0"

  :warn-on-reflection true

  :source-paths ["src/clojure" "../common/clojure"]
  :java-source-paths ["src/java" "../common/java" "gen"]
  
  :dependencies [[org.clojure-android/clojure "1.5.1-jb"]
                 [neko/neko "3.0.0-beta6"]
                 [com.h2database/h2 "1.3.173"]
                 [markdown-clj "0.9.31"]]
  :profiles {:dev {:dependencies [[android/tools.nrepl "0.2.0-bigstack"]]
                   :android {:aot :all-with-unused}}
             :release {:android
                       {;; Specify the path to your private
                        ;; keystore and the the alias of the
                        ;; key you want to sign APKs with.
                        ;; :keystore-path "/home/user/.android/private.keystore"
                        ;; :key-alias "mykeyalias"
                        :aot :all}}}

  :android {:external-classes-paths ["libs/android-support-v13.jar"]
            :target-version "15"
            :aot-exclude-ns ["clojure.parallel" "clojure.core.reducers"]
            :dex-opts ["-JXmx2048M"]})
