package com.example.demo;

import java.io.File;
import org.eclipse.jgit.api.BlameCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.blame.BlameResult;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class Jgit {

    // DOESNT WORK
    // https://mvnrepository.com/artifact/org.eclipse.jgit/org.eclipse.jgit
    // WORKS
    // implementation 'org.eclipse.jgit:org.eclipse.jgit:1.2.0.201112221803-r'
    // WORKS
    // implementation 'org.eclipse.jgit:org.eclipse.jgit:3.7.1.201504261725-r'
    // WORKS
    // implementation 'org.eclipse.jgit:org.eclipse.jgit:4.11.9.201909030838-r'
    // DOESNT WORK
    // implementation 'org.eclipse.jgit:org.eclipse.jgit:5.13.3.202401111512-r'
    // WORKS
    // implementation 'org.eclipse.jgit:org.eclipse.jgit:5.3.0.201903130848-r'
    // DOESNT WORK
    // implementation 'org.eclipse.jgit:org.eclipse.jgit:5.7.0.202003110725-r'
    // WORKS
    // implementation 'org.eclipse.jgit:org.eclipse.jgit:5.5.1.201910021850-r'
    // DOESNT WORK
    // implementation 'org.eclipse.jgit:org.eclipse.jgit:5.6.1.202002131546-r'
    // DOESNT WORK
    // implementation 'org.eclipse.jgit:org.eclipse.jgit:5.6.0.201912101111-r'
    // https://mvnrepository.com/artifact/org.eclipse.jgit/org.eclipse.jgit
    // implementation 'org.eclipse.jgit:org.eclipse.jgit:7.1.0.202411261347-r'

    static final String REPO = "/Users/kapil-mangtani/IdeaProjects/jgit-test4/.git";
    static final String PATH1 = "settings.gradle";
    static final String PATH2 = ".github/workflows/sonar-analysis.yml";
    static final String PATH3 = "demo/src/main/java/com/example/demo/DemoApplication.java";

    public static void main(String[] args) throws Exception {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Git git = new Git(
                builder.setGitDir(new File(REPO)).readEnvironment().findGitDir().build());
        // System.out.println("Latest Commit: " + git.log().setMaxCount(1).call().iterator().next());
        BlameCommand blameCommand = git.blame().setFilePath(PATH1);
        BlameResult result = blameCommand.call();
        assert result != null;
        BlameCommand blameCommand1 = git.blame().setFilePath(PATH2);
        BlameResult result1 = blameCommand1.call();
        assert result1 != null;
        BlameCommand blameCommand2 = git.blame().setFilePath(PATH3);
        BlameResult result2 = blameCommand2.call();
        assert result2 != null;
        System.out.println("done");
    }
}
