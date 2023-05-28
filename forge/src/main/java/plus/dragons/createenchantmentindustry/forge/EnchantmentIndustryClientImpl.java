package plus.dragons.createenchantmentindustry.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import plus.dragons.createenchantmentindustry.EnchantmentIndustryClient;

@EventBusSubscriber(Dist.CLIENT)
public class EnchantmentIndustryClientImpl {
    public static void init() {
        EnchantmentIndustryClient.init();
        //EnchantmentIndustryImpl.bus.addListener(EnchantmentIndustryClientImpl::onModelLayerRegistration);
        //EnchantmentIndustryImpl.bus.addListener(EnchantmentIndustryClientImpl::onBuiltinPackRegistration);
    }
}