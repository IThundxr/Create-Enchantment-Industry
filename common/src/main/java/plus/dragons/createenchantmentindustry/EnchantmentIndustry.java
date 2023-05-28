package plus.dragons.createenchantmentindustry;

import plus.dragons.createenchantmentindustry.entry.CeiItems;
import plus.dragons.createenchantmentindustry.util.Utils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.MixinEnvironment;

public class EnchantmentIndustry {
    public static final String MODID = "create_enchantment_industry";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final String VERSION = findVersion();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID);

    public static void init() {
        ModSetup.register();
        finalizeRegistrate();

        if (Utils.isDevEnv()) // force all mixins to load in dev
            MixinEnvironment.getCurrentEnvironment().audit();
    }

    public static ResourceLocation asResource(String name) {
        return new ResourceLocation(MODID, name);
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }

    @ExpectPlatform
    public static String findVersion() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void finalizeRegistrate() {
        throw new AssertionError();
    }
}
