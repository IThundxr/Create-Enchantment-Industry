package plus.dragons.createenchantmentindustry.forge;

import com.mojang.brigadier.CommandDispatcher;
import plus.dragons.createenchantmentindustry.EnchantmentIndustry;
import plus.dragons.createenchantmentindustry.multiloader.Env;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands.CommandSelection;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.util.MavenVersionStringHelper;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forgespi.language.IModInfo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

@Mod(EnchantmentIndustry.MODID)
public class EnchantmentIndustryImpl {
    static IEventBus bus;

    public EnchantmentIndustryImpl() {
        bus = FMLJavaModLoadingContext.get().getModEventBus();
        EnchantmentIndustry.init();
        //noinspection Convert2MethodRef
        Env.CLIENT.runIfCurrent(() -> () -> EnchantmentIndustryClientImpl.init());
    }

    public static String findVersion() {
        String versionString = "UNKNOWN";

        List<IModInfo> infoList = ModList.get().getModFileById(EnchantmentIndustry.MODID).getMods();
        if (infoList.size() > 1) {
            EnchantmentIndustry.LOGGER.error("Multiple mods for MOD_ID: " + EnchantmentIndustry.MODID);
        }
        for (IModInfo info : infoList) {
            if (info.getModId().equals(EnchantmentIndustry.MODID)) {
                versionString = MavenVersionStringHelper.artifactVersionToString(info.getVersion());
                break;
            }
        }
        return versionString;
    }

    public static void finalizeRegistrate() {
        EnchantmentIndustry.registrate().registerEventListeners(bus);
    }

    private static final Set<BiConsumer<CommandDispatcher<CommandSourceStack>, Boolean>> commandConsumers = new HashSet<>();

    public static void registerCommands(BiConsumer<CommandDispatcher<CommandSourceStack>, Boolean> consumer) {
        commandConsumers.add(consumer);
    }

    @SubscribeEvent
    public static void onCommandRegistration(RegisterCommandsEvent event) {
        CommandSelection selection = event.getEnvironment();
        boolean dedicated = selection == CommandSelection.ALL || selection == CommandSelection.DEDICATED;
        commandConsumers.forEach(consumer -> consumer.accept(event.getDispatcher(), dedicated));
    }

    public static void registerConfig(ModConfig.Type type, ForgeConfigSpec spec) {
        ModLoadingContext.get().registerConfig(type, spec);
    }
}