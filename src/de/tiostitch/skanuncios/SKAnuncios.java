package de.tiostitch.skanuncios;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;


public class SKAnuncios extends JavaPlugin implements Listener {

    public static SKAnuncios plugin;

    long time = getConfig().getLong("time");
    long period = getConfig().getLong("time");

    @Override
    public void onEnable() {
        plugin = this;

        Bukkit.getConsoleSender().sendMessage("§6[SKAnuncios] §ePlugin On §a✔");
        Bukkit.getConsoleSender().sendMessage("§ePT-BR: Obrigado por usar meu plugin!");
        Bukkit.getConsoleSender().sendMessage("§eEnglish: Thanks for using my plugin!");
        Bukkit.getConsoleSender().sendMessage("§eSpanish: ¡Gracias por usar mi complemento!");

        Bukkit.getPluginManager().registerEvents(this, this);
        loadConfig();


        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            public void run() {
                try {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        Anunciar.getRandomMessage();
                    }
                } catch (NullPointerException e2) {
                    return;
                }
            }
        }, time, period);
    }

    @EventHandler
    public void onRespawnPlayer(PlayerRespawnEvent e) {
        Player p = e.getPlayer();

        if (getConfig().getBoolean("anunciar-death") == false) {
            return;
        } else {
            if (getConfig().getBoolean("anunciar-death") == true) {
                for (Player pall : Bukkit.getOnlinePlayers()) {
                    getConfig().getString("anunciar-death-message").replace("<player>", p.getName());
                }
            }
        }
    }

    @EventHandler
    public void onDeathPlayer(PlayerDeathEvent e) {
        Player p = e.getEntity();

        if (getConfig().getBoolean("anunciar-respawn") == false) {
            return;
        } else {
            if (getConfig().getBoolean("anunciar-respawn") == true) {
                for (Player pall : Bukkit.getOnlinePlayers()) {
                    getConfig().getString("anunciar-respawn-message").replace("<player>", p.getName());
                }
            }
        }
    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage("§6[SKAnuncios] §ePlugin Off §c✖");
        Bukkit.getConsoleSender().sendMessage("§ePT-BR: Obrigado por usar meu plugin!");
        Bukkit.getConsoleSender().sendMessage("§eEnglish: Thanks for using my plugin!");
        Bukkit.getConsoleSender().sendMessage("§eSpanish: ¡Gracias por usar mi complemento!");

    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
