package fr.hytorke.simpleguimaker;

import fr.hytorke.simpleguimaker.commands.CreateGui;
import fr.hytorke.simpleguimaker.commands.OpenGui;
import fr.hytorke.simpleguimaker.commands.setGuiOpenner;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleGuiMaker extends JavaPlugin {

    public static ArrayList<String> guiName = new ArrayList<>();
    @Override
    public void onEnable() {
        getLogger().info("Simplegui On.");
        getCommand("CreateGui").setExecutor(new CreateGui());
        getCommand("setGuiOpenner").setExecutor(new setGuiOpenner());
        getCommand("OpenGui").setExecutor(new OpenGui());
    }
}

//[#####################]
//[     By Hytorke      ]
//[#####################]