package cortex.perms.Commands;

import cortex.perms.Players.RankHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PunishCMD implements CommandExecutor {
    RankHandler rankHandler = new RankHandler();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
        if(!(sender instanceof Player)){sender.sendMessage("Player only command");}
        Player player = (Player) sender;
        int rank = rankHandler.getRank(player);
        if(rank >= 7){
            if(args.length != 2) {
                Player target = Bukkit.getPlayer(args[0]);
                String kickMSG = args[2];
                if (target != null && target.isOnline()) {
                    if (args[1].equalsIgnoreCase("kick")) {
                        target.kickPlayer(kickMSG);
                        player.sendMessage("Kicked: " + target.getDisplayName());
                    }else if(args[1].equalsIgnoreCase("ban")){
                        target.isBanned();
                        player.sendMessage("Player banned!");
                    }
                }else{
                    player.sendMessage("Player not found!");
                }
            }else{
                player.sendMessage("Ussage: /punish <player> <kick/ban> <reason>");
            }
        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cError! &aNo Perms!"));
        }
        return false;
    }
}
