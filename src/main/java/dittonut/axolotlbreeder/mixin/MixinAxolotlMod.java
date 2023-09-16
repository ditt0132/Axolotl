package dittonut.axolotlbreeder.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Timer;
import java.util.TimerTask;


@Mixin(AnimalEntity.class)
public abstract class MixinAxolotlMod extends PassiveEntity {


    protected MixinAxolotlMod(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "handleStatus", at = @At("RETURN"))
    private void onHandleStatus(byte status, CallbackInfo ci) {
        if (status == 18) {
            // the entity is breeding!!!!!
            if (this.getType().equals(EntityType.AXOLOTL)) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                    }
                }, 300000); /// 300,000 ms = 5m
            }
        }
    }
}
