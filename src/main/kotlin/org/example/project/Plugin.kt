package org.example.project

//import dev.jorel.commandapi.CommandAPI
//import dev.jorel.commandapi.CommandAPIBukkitConfig
import org.bstats.bukkit.Metrics
import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class Plugin : JavaPlugin() {

    private val pair = Pair("Hello World!", "Goodbye World!")

    override fun onEnable() {
        logger.info(pair.first)

//        CommandAPI.onLoad(CommandAPIBukkitConfig(this))
//        CommandAPI.onEnable()

        try {
//            Metrics(this, https://bstats.org/what-is-my-plugin-id)
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

    override fun onDisable() {
        logger.info(pair.second)
    }
}
