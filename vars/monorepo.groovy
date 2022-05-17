/**
 * The step entry point.
 */
def call() {
    String repositoryName = "monorepo-sample";
    String rootFolderPath = "Generated/$repositoryName"

    def provision = load "provisionJenkinsItems.groovy"

    List<String> jenkinsfilePaths = provisionItems(rootFolderPath, env.GIT_URL)
    List<String> multibranchPipelinesToRun = findMultibranchPipelinesToRun(jenkinsfilePaths)
    runPipelines(rootFolderPath, multibranchPipelinesToRun)
}