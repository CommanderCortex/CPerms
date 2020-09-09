package cortex.perms.Commands;

import cortex.perms.Players.RankHandler;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QuickGameModeGMD implements CommandExecutor {
    RankHandler rankHandler = new RankHandler();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
        if(!(sender instanceof Player)){sender.sendMessage("Player Command Only");}
        Player player = (Player) sender;
        int rank = rankHandler.getRank(player);
        if(rank >= 8){
            if(player.getGameMode().equals(GameMode.CREATIVE)){
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage("Gamemode Updated");
            }else{
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage("Gamemode Updated");
            }
        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cError! &aNo Perms!"));
        }
        return false;
    }
}
