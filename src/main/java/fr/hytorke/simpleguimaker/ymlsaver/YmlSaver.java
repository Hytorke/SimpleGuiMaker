package fr.hytorke.simpleguimaker.ymlsaver;

import fr.hytorke.simpleguimaker.SimpleGuiMaker;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class YmlSaver {

    public static File file = new File(SimpleGuiMaker.getInstance().getDataFolder(), "GuiList.yml");
    public static FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);

    public void OnDisable() {

    }

    public static void SaveGui(int iSize, String iName) {
        configuration.set(iName, iSize);
        try {
            configuration.save(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
