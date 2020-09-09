package cortex.perms;

import cortex.perms.Commands.ClearChatCMD;
import cortex.perms.Commands.PunishCMD;
import cortex.perms.Commands.QuickGameModeGMD;
import cortex.perms.Commands.SetRankCMD;
import cortex.perms.Events.OnPlayerChat;
import cortex.perms.Events.OnPlayerJoinEvent;
import cortex.perms.Files.FileHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Perms extends JavaPlugin {

    @Override
    public void onEnable() {
        FileHandler.setup();
        EventGetter();
        CommandGetter();
    }
    public void EventGetter(){
        getServer().getPluginManager().registerEvents(new OnPlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerChat(), this);
    }
    public void CommandGetter(){
        getServer().getPluginCommand("clearchat").setExecutor(new ClearChatCMD());
        getServer().getPluginCommand("setrank").setExecutor(new SetRankCMD());
        getServer().getPluginCommand("gm").setExecutor(new QuickGameModeGMD());
        getServer().getPluginCommand("punish").setExecutor(new PunishCMD());
    }
}


