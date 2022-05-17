/**
 * The step entry point.
 */
def call() {
    println "=====================> $env.JOB_NAME"
    String repositoryName = env.JOB_NAME.split('/')[1]
    println "=====================> $repositoryName"
    String rootFolderPath = "Generated/$repositoryName"

    List<String> jenkinsfilePaths = provisionItems(rootFolderPath, env.GIT_URL)
    List<String> multibranchPipelinesToRun = findMultibranchPipelinesToRun(jenkinsfilePaths)
    runPipelines(rootFolderPath, multibranchPipelinesToRun)
}