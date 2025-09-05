package org.example.project

import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class Plugin : JavaPlugin() {

    private val pair = Pair<String, String>("Hello World!", "Goodbye World!")

    override fun onEnable() {
        logger.info(pair.first)
    }

    override fun onDisable() {
        logger.info(pair.second)
    }
}
