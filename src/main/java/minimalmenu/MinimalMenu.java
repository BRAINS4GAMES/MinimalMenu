package minimalmenu;

import minimalmenu.config.ConfigHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class MinimalMenu implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "minimalmenu";
    public static final String MOD_NAME = "MinimalMenu";

    private static ConfigHandler configHandler;

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing MinimalMenu... searching for mods with compatibility.");
        if (allInstalledIDS().contains("modmenu")) {
            log(Level.INFO, "Mod menu is installed, will adjust.");
        } if (allInstalledIDS().contains("better_mod_menu")) {
            log(Level.WARN, "Advised removal of Better Mod Button for cleaner look.");
        }

        log(Level.INFO, "Initialising config handler instance.");
        configHandler = new ConfigHandler();
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

    public static ArrayList<String> allInstalledIDS() {
        ArrayList<String> IDs = new ArrayList<>();
        for (ModContainer mod : FabricLoader.getInstance().getAllMods()) {
            IDs.add(mod.getMetadata().getId());
        }
        return IDs;
    }

    public static ConfigHandler getConfigHandler() {
        return configHandler;
    }
}