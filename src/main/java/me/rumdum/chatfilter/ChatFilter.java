package me.rumdum.chatfilter;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatFilter extends JavaPlugin implements Listener {

    private final String[] blacklistedWords = {"anal", "anus",
            "arse", "ass", "ballsack", "balls", "bastard", "bitch",
            "biatch", "bloody", "blowjob", "blow job", "bollock",
            "bollok", "boner", "boob", "bugger", "bum", "butt",
            "buttplug", "clitoris", "cock", "coon", "crap",
            "cunt", "damn", "dick", "dildo", "dyke", "fag",
            "feck", "fellate", "fellatio", "felching", "fuck",
            "f u c k", "fudgepacker", "fudge packer", "flange",
            "Goddamn", "God damn", "hell", "homo", "jerk",
            "jizz", "knobend", "knob end", "labia", "lmao",
            "lmfao", "muff", "nigger", "nigga", "omg", "penis",
            "piss", "poop", "prick", "pube", "pussy", "queer",
            "scrotum", "sex", "shit", "s hit", "sh1t", "slut",
            "smegma", "spunk", "tit", "tosser", "turd", "twat",
            "vagina", "wank", "whore", "wtf"};

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        for (String s : blacklistedWords) {
            if (event.getMessage().contains(s)) {
                event.setCancelled(true);
                String originalMessage = event.getMessage();
                StringBuilder replacement = new StringBuilder();
                for (int i=0;i<=s.length();i++) {
                    replacement.append("#");
                }
                originalMessage.replace(s, replacement.toString());
                Bukkit.broadcastMessage(originalMessage);
            }
        }
    }
}
