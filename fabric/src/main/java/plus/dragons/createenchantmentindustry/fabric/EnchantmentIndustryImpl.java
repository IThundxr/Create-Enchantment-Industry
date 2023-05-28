package plus.dragons.createenchantmentindustry.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import plus.dragons.createenchantmentindustry.EnchantmentIndustry;

public class EnchantmentIndustryImpl implements ModInitializer {
    @Override
    public void onInitialize() {
        EnchantmentIndustry.init();
    }

    public static String findVersion() {
        return FabricLoader.getInstance()
                .getModContainer(EnchantmentIndustry.MODID)
                .orElseThrow()
                .getMetadata()
                .getVersion()
                .getFriendlyString();
    }

    public static void finalizeRegistrate() {
        EnchantmentIndustry.registrate().register();
    }
}