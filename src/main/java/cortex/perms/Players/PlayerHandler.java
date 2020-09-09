package cortex.perms.Players;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerHandler {
    static Ranks ranks = new Ranks();
    public static void setupPlayer(Player player){
        File playerFile = new File("plugins/Cortex/PlayerData/" + player.getUniqueId() + ".yml");
        if(!playerFile.exists()) { try { playerFile.createNewFile(); } catch (IOException e) { e.printStackTrace(); }
            YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(playerFile);
            yamlConfiguration.addDefault("PlayerName", player.getName());
            yamlConfiguration.addDefault("DisplayName", player.getDisplayName());
            yamlConfiguration.addDefault("Rank", ranks.GUEST);
            yamlConfiguration.options().copyDefaults(true);
            try { yamlConfiguration.save(playerFile); } catch (IOException e) { e.printStackTrace(); }
        }
    }
}
