load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "4.0"
RULES_JVM_EXTERNAL_SHA = "31701ad93dbfe544d597dbe62c9a1fdd76d81d8a9150c2bf1ecf928ecdf97169"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "com.google.guava:guava:30.1.1-jre",
        "com.google.inject:guice:5.0.1",
        "com.google.truth:truth:1.1",
        "io.github.bonigarcia:webdrivermanager:5.0.3",
        "junit:junit:4.12",
        "org.junit.jupiter:junit-jupiter:5.8.0",
        "org.seleniumhq.selenium:selenium-api:3.141.59",
        "org.seleniumhq.selenium:selenium-chrome-driver:3.141.59",
        "org.seleniumhq.selenium:selenium-java:3.141.59",
        "org.seleniumhq.selenium:selenium-java:3.141.59",
        "org.seleniumhq.selenium:selenium-support:3.141.59"
    ],

    fetch_sources = True,
    repositories = [
        "https://jcenter.bintray.com/",
        "https://mvnrepository.com",
        "https://repo1.maven.org/maven2",
        "http://uk.maven.org/maven2"
    ],
)