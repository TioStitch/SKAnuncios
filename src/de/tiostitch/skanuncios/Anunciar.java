package de.tiostitch.skanuncios;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class Anunciar {

    public static String discord_tokem = SKAnuncios.plugin.getConfig().getString("discord-tokem");

    public static String anuncio1 = SKAnuncios.plugin.getConfig().getString("anuncio-1");
    public static String anuncio2 = SKAnuncios.plugin.getConfig().getString("anuncio-2");
    public static String anuncio3 = SKAnuncios.plugin.getConfig().getString("anuncio-3");
    public static String anuncio4 = SKAnuncios.plugin.getConfig().getString("anuncio-4");
    public static String anuncio5 = SKAnuncios.plugin.getConfig().getString("anuncio-5");
    public static String anuncio6 = SKAnuncios.plugin.getConfig().getString("anuncio-6");

    public static String getRandomMessage() {
        int random = (new Random()).nextInt(100) + 1;

        if (random <= 11) return anuncio1;
        if (random <= 22) return anuncio2;
        if (random <= 33) return anuncio3;
        if (random <= 44) return anuncio4;
        if (random <= 55) return anuncio5;
        return anuncio6;
    }
}
