package cortex.perms.Commands;

import cortex.perms.Players.RankHandler;
import cortex.perms.Players.Ranks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetRankCMD implements CommandExecutor {
    RankHandler rankHandler = new RankHandler();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){ sender.sendMessage("Player Command Only Rn! Sorry!!"); }
        Player player = (Player) sender;
        int rank = rankHandler.getRank(player);
        Player target = Bukkit.getPlayer(args[0]);
        if(rank >= 8){
            if(target != null && target.isOnline()){
                switch (args[1]){
                    case "OWNER":
                        rankHandler.setRank(target, rankHandler.OWNER);
                        rankHandler.TabRankGetter();
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aRank Updated to &4&lOWNER&a for Player " + target.getDisplayName()));
                        break;
                    case "ADMIN":
                        rankHandler.setRank(target, rankHandler.ADMIN);
                        rankHandler.TabRankGetter();
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aRank Updated to &4&lADMIN&a for Player " + target.getDisplayName()));
                        break;
                    case "DEV":
                        rankHandler.setRank(target, rankHandler.DEVELOPER);
                        rankHandler.TabRankGetter();
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aRank Updated to &4&lDEV&a for Player " + target.getDisplayName()));
                        break;
                    case "MOD":
                        rankHandler.setRank(target, rankHandler.MODERATOR);
                        rankHandler.TabRankGetter();
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aRank Updated to &5&lMOD&a for Player " + target.getDisplayName()));
                        break;
                    case "MEMBER":
                        rankHandler.setRank(target, rankHandler.MEMBER);
                        rankHandler.TabRankGetter();
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aRank Updated to &b&lMEMBER&a for Player " + target.getDisplayName()));
                        break;
                    default:
                        rankHandler.setRank(target, rankHandler.GUEST);
                        rankHandler.TabRankGetter();
                        player.sendMessage("Error! Incorrect use of command! Setting " + target.getDisplayName() + " To Guest!");
                }
            }else{
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cError! &aTarget Cannot be Null & or is not online!"));
            }
        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cError! &aNo permissions!"));
        }

        return false;
    }
}
