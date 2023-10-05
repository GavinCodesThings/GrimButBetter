package ac.grim.grimac.checks.impl.combat.autoblock;

import ac.grim.grimac.checks.Check;
import ac.grim.grimac.checks.type.PacketCheck;
import ac.grim.grimac.player.GrimPlayer;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientInteractEntity;
import org.bukkit.entity.Player;

public class AutoblockA extends Check implements PacketCheck {
    public AutoblockA(GrimPlayer player) {
        super(player);
    }
    /*
    Written by Gavin Reid on 10/4/2023 @ 4:00 PM

    Yes I know my code is messy
     */

    // TODO: Make sure this works

    @Override
    public void onPacketReceive(PacketReceiveEvent event) {
        if (event.getPacketType() == PacketType.Play.Client.INTERACT_ENTITY) {
            WrapperPlayClientInteractEntity wrapper = new WrapperPlayClientInteractEntity(event);
            if (wrapper.getAction() == WrapperPlayClientInteractEntity.InteractAction.ATTACK) {
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    if (wrapper.getPacketEntityID() == player.bukkitPlayer) {
                        Player plr = onlinePlayer;
                    if (plr.isBlocking()) {
                        flagAndAlert();
                    }
                    }
                }
            }
        }
    }
}
