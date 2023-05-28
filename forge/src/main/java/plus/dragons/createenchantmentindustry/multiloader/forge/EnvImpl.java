package plus.dragons.createenchantmentindustry.multiloader.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;
import plus.dragons.createenchantmentindustry.multiloader.Env;

public class EnvImpl {
    public static Env getCurrent() {
        return FMLEnvironment.dist == Dist.CLIENT ? Env.CLIENT : Env.SERVER;
    }
}
