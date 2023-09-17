package dittonut.axolotlbreeder.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.text.Text;
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
            MinecraftClient.getInstance().player.sendMessage(Text.of("text at breed(not checked)"));
            MinecraftClient.getInstance().player.sendMessage(Text.of(this.getType().toString()));
            if (this.getType().equals(EntityType.AXOLOTL)) {
                // Timer timer = new Timer();
                MinecraftClient.getInstance().player.sendMessage(Text.of("text at breed(only axolotl)"));
                MixinAxolotlMod axolotl = this;
                assert MinecraftClient.getInstance().player != null;
                MinecraftClient.getInstance().player.sendMessage(Text.of("after setGlow"));
                /*
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        axolotl.setGlowing(true);
                    }
                }, 3); /// 300,000 ms = 5m
                */
            }
        }
    }
}
