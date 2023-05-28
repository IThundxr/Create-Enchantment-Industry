package plus.dragons.createenchantmentindustry.multiloader.fabric;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import plus.dragons.createenchantmentindustry.multiloader.Env;

public class EnvImpl {
    public static Env getCurrent() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT ? Env.CLIENT : Env.SERVER;
    }
}
