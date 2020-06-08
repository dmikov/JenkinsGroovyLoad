def buildThis(projectFolder) {
    if (!currentBuild.changeSets) {
        return true
    }
    for (changeLogSet in currentBuild.changeSets) {
        for (entry in changeLogSet.getItems()) {
            for (file in entry.getAffectedFiles()) {
                if (file.getPath().contains(projectFolder)) {
                    return true
                }
            }
        }
    }
    return false
}

def getCodeFilesForAnalysis() {
    
}

def printEnv() {
    println(env.IMAGE_GROOVY_LOAD)
}

def printThis(value) {
    println(value)
}

return this