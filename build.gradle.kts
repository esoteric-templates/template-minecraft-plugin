import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import java.util.jar.Attributes

plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.shadow)

    alias(libs.plugins.paper)
    alias(libs.plugins.paper.convention)
    alias(libs.plugins.paper.run)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.kotlin.test)
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform)

    paperweight.paperDevBundle("1.21.8-R0.1-SNAPSHOT")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<ShadowJar>().configureEach {
    minimize()

    enableAutoRelocation = true
    relocationPrefix = "org.example.dependencies"
}

tasks.withType<AbstractArchiveTask>().configureEach {
    isPreserveFileTimestamps = false
    isReproducibleFileOrder = true

    from("LICENSE")
    from("assets/text/licenses/") {
        into("licenses/")
    }

    filePermissions {
        user.read = true
        user.write = true
        user.execute = false

        group.read = true
        group.write = false
        group.execute = false

        other.read = true
        other.write = false
        other.execute = false
    }

    dirPermissions {
        user.read = true
        user.write = true
        user.execute = true

        group.read = true
        group.write = false
        group.execute = true

        other.read = false
        other.write = false
        other.execute = true
    }
}

sourceSets.main {
    resourceFactory {
        paperPluginYaml {
            name = "Template"

            main = "org.example.Plugin"
            apiVersion = "1.21.8"
            version = "0.1.0-SNAPSHOT"

            authors.add(
                "Esoteric Enderman"
            )

            website = "https://gitlab.com/esoterictemplates/template-minecraft-plugin"
        }
    }
}
