package dittonut.axolotlbreeder.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class MixinIsGlowing {
    @Shadow public abstract EntityType<?> getType();

    @Inject(at = @At("HEAD"), method = "isGlowing", cancellable = true)
    public void glowOverride(CallbackInfoReturnable<Boolean> ci) {
        if(this.getType().equals(EntityType.AXOLOTL)) {
            if (((AnimalEntity) this).isInLove()) {

            }
        }

    }
}