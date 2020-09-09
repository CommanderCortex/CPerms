package cortex.perms.Events;

import cortex.perms.Players.PlayerHandler;
import cortex.perms.Players.RankHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoinEvent implements Listener {
    RankHandler rankHandler = new RankHandler();
    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        PlayerHandler.setupPlayer(player);
        rankHandler.TabRankGetter();
    }
}
