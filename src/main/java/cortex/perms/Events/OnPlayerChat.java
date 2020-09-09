package cortex.perms.Events;

import cortex.perms.Players.RankHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OnPlayerChat implements Listener {
    RankHandler rankHandler = new RankHandler();
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){
        event.setCancelled(true);
        Player player = event.getPlayer();
        String PlayerMSG = event.getMessage();
        String DisplayName = player.getDisplayName();
        String PlayerPrefix = rankHandler.getRankPrefix(rankHandler.getRank(player));
        Bukkit.broadcastMessage(PlayerPrefix + ChatColor.YELLOW + DisplayName + ChatColor.GOLD + ChatColor.BOLD + " >> " + ChatColor.WHITE + PlayerMSG);
    }
}
