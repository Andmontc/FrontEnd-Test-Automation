load("@rules_java//java:defs.bzl", "java_test")

java_test(
    name = "StarbucksTests",
    srcs = glob(["*.java"]),
    deps = [
            "//src/main/java/org/google/globant/main/pages:StarbuckPages",
            "@maven//:com_google_inject_guice",
            "@maven//:com_google_truth_truth",
            "@maven//:io_github_bonigarcia_webdrivermanager",
            "@maven//:junit_junit",
            "@maven//:org_seleniumhq_selenium_selenium_java"
    ],
)