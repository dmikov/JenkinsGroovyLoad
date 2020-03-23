def buildThis(projectFolder) {
    if (!currentBuild.changeSets) {
        return true
    }
    for (changeLogSet in currentBuild.changeSets) {
        for (entry in changeLogSet.getItems()) {
            for (file in entry.getAffectedFiles()) {
                if (file.getPath().contains(projectFolder)) {
                    println(file.getPath())
                    return true
                }
            }
        }
    }
    return false
}

def printEnv() {
    println(env.IMAGE_ENVIRONMENTUPDATER)
}

def printThis(value) {
    println(value)
}

return this