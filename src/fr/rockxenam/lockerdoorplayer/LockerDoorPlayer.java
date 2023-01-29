package fr.rockxenam.lockerdoorplayer;

import fr.rockxenam.lockerdoorplayer.commands.ldp;
import fr.rockxenam.lockerdoorplayer.events.OnPlayerClick;
import fr.rockxenam.lockerdoorplayer.messages.consoleMessages;
import fr.rockxenam.lockerdoorplayer.messages.playerMessages;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
public class LockerDoorPlayer extends JavaPlugin {
    public String name = "LockerDoorPlayer";
    public static LockerDoorPlayer instance;
    public static DataFile loader;

    public static playerMessages playerMessages;

    public static consoleMessages consoleMessages;

    /* Enable Section */
    @Override
    public void onEnable(){
        instance = this;

        loader = new DataFile(instance);
        loader.create();

        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();

        /*Enregistrement des Events*////////////////
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new OnPlayerClick(instance), instance);

        getCommand("ldp").setExecutor(new ldp(this));

        playerMessages = new playerMessages(this);
        consoleMessages = new consoleMessages(this);


        this.consoleMessages.getEnable();

    }

    /* Disbale Section */
    @Override
    public void onDisable(){
        playerMessages = new playerMessages(this);

        this.consoleMessages.getDisable();
    }


    /* System.out function P */
    public void p(String i){  System.out.println(i);  }

    public DataFile getDataLoader() {
        return loader;
    }

}