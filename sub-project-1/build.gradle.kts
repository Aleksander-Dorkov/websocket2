plugins {
    application
}
application {
    mainClass = "subproject1.Main"
}

dependencies {
    implementation(project(":common"))
}
