package cortex.perms.Players;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.io.IOException;

public class RankHandler extends Ranks {

    public int getRank(Player player){
        File getUserRank = new File("plugins/Cortex/PlayerData/" + player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(getUserRank);
        return yamlConfiguration.getInt("Rank");
    }
    public void setRank(Player player, int Rank){
        File userFile = new File("plugins/Cortex/PlayerData/" + player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        yamlConfiguration.set("Rank", Rank);
        try { yamlConfiguration.save(userFile); } catch (IOException e) { e.printStackTrace(); }
    }
    public String getRankPrefix(int Rank){
        if(Rank == OWNER){
            return ChatColor.translateAlternateColorCodes('&', "&4&lOWNER &r");
        }else if(Rank == ADMIN){
            return ChatColor.translateAlternateColorCodes('&', "&4&lADMIN &r");
        }else if(Rank == DEVELOPER){
            return ChatColor.translateAlternateColorCodes('&', "&4&lDEV &r");
        }else if(Rank == MODERATOR){
            return ChatColor.translateAlternateColorCodes('&', "&5&lMOD &r");
        }else if (Rank == MEMBER){
            return ChatColor.translateAlternateColorCodes('&', "&b&lMEMBER &r");
        }
        return ChatColor.GRAY.toString();
    }
    public void TabRankGetter(){
        for(Player player : Bukkit.getOnlinePlayers()){
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            for(Player player1 : Bukkit.getOnlinePlayers()){
                String prefix = getRankPrefix(getRank(player));
                Team team = scoreboard.registerNewTeam(player1.getDisplayName());
                team.setPrefix(prefix);
                team.addEntry(player1.getDisplayName());
            }
            player.setScoreboard(scoreboard);
        }
    }
}
