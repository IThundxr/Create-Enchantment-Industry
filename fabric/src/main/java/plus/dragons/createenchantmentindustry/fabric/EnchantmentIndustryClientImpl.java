package plus.dragons.createenchantmentindustry.fabric;

import net.fabricmc.api.ClientModInitializer;
import plus.dragons.createenchantmentindustry.EnchantmentIndustryClient;

public class EnchantmentIndustryClientImpl implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EnchantmentIndustryClient.init();
    }
}
