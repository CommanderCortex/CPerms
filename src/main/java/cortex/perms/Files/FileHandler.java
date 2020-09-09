package cortex.perms.Files;

import sun.applet.Main;

import java.io.File;

public class FileHandler {
    public static void setup(){
        String MainDIR = "plugins/Cortex/";
        File MAIN = new File(MainDIR);
        if(!MAIN.exists()) MAIN.mkdir();
        File PlayerDATA = new File(MainDIR + "PlayerData");
        if(!PlayerDATA.exists()) PlayerDATA.mkdir();
    }
}
