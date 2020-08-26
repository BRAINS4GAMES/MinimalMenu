package minimalmenu.mixin;

import minimalmenu.config.ConfigHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.gui.RotatingCubeMapRenderer.class)
public class RotatingCubeMapRendererMixin {
    @Shadow private float time;

    @Inject(at = @At("HEAD"), method = "render")
    public void renderHead(float delta, float alpha, CallbackInfo info) {
        if (ConfigHandler.STOP_SPIN) {
            time -= delta;
        }
    }
}
