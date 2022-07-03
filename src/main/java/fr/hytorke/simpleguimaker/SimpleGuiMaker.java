package fr.hytorke.simpleguimaker;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import fr.hytorke.simpleguimaker.commands.CreateGui;
import fr.hytorke.simpleguimaker.commands.OpenGui;
import fr.hytorke.simpleguimaker.commands.setGuiOpenner;
import fr.hytorke.simpleguimaker.utils.GUI;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class SimpleGuiMaker extends JavaPlugin {

    public static ArrayList<String> guiName = new ArrayList<>();
    @Override
    public void onEnable() {
        getLogger().info("Simplegui On.");
        getCommand("SimpleGui").setExecutor(new CreateGui());
        getCommand("setGuiOpenner").setExecutor(new setGuiOpenner());
        getCommand("OpenGui").setExecutor(new OpenGui());
    }
}

//[#####################]
//[     By Hytorke      ]
//[#####################]