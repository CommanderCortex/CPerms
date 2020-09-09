package cortex.perms.Commands;

import cortex.perms.Players.RankHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCMD implements CommandExecutor {
    RankHandler rankHandler = new RankHandler();
    public void clearChat(){ for(int i = 0; i<150; i++){ Bukkit.broadcastMessage(""); } Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&bChat Has Been Cleared")); }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
        if(!(sender instanceof Player)){ clearChat(); }
        Player player = (Player) sender;
        int rank =  rankHandler.getRank(player);
        if(rank >= 7){
            clearChat();
        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cError! &aNo Perms!"));
        }
        return false;
    }
}
