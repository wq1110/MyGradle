package com.example.lib_gradle
import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin implements Plugin<Project> {
    @Override
    void apply(Project rootProject) {
        println("这是插件：${this.class.name}")
    }
}