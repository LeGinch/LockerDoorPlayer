package fr.rockxenam.lockerdoorplayer.events;
import fr.rockxenam.lockerdoorplayer.LockerDoorPlayer;
import fr.rockxenam.lockerdoorplayer.messages.playerMessages;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
public class OnPlayerClick implements Listener {

    private static LockerDoorPlayer  instance;

    private static playerMessages messages;

    public OnPlayerClick(final LockerDoorPlayer instance){

        OnPlayerClick.instance = instance;

        messages = new playerMessages(instance);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();

        if (p.getInventory().getItemInMainHand().getType().equals(Material.STONE_SWORD) && p.isOp()) {
            if (a.equals(Action.RIGHT_CLICK_BLOCK)) {
                if (p.getTargetBlock(null, 100).getType().toString().contains("DOOR")) {
                    Location targetLocation = p.getTargetBlock(null, 100).getLocation();
                    double targetX = targetLocation.getX();
                    double targetY = targetLocation.getY();
                    double targetZ = targetLocation.getZ();
                    double verifyUpY = targetY + 1;
                    double goodY;
                    Location doorUpLocation = new Location(e.getPlayer().getWorld(), targetX, verifyUpY, targetZ);

                    if (doorUpLocation.getBlock().getType().toString().contains("DOOR")) {
                        goodY = targetY;
                    } else {
                        goodY = targetY - 1;
                    }
                    String n = "" + String.valueOf(targetX) + "" + String.valueOf(goodY) + "" + String.valueOf(targetZ);
                    String name = n.replaceAll("\\p{Punct}", "");

                    double dYF = instance.getDataLoader().getYByName(name);

                    if (dYF != 0) { //si la position existe
                        this.messages.getDoorExist(p, String.valueOf(name));
                    } else {
                        instance.getDataLoader().addDoor(name, targetX, goodY, targetZ);
                        this.messages.getSetDoor(p, name);

                    }
                }
            }
        } else if (p.getInventory().getItemInMainHand().getType().equals(Material.STONE_SWORD) && !p.isOp()) {
            if (a.equals(Action.RIGHT_CLICK_BLOCK)) {
                if (p.getTargetBlock(null, 100).getType().toString().contains("DOOR")) {
                    Location targetLocation = p.getTargetBlock(null, 100).getLocation();
                    double targetX = targetLocation.getX();
                    double targetY = targetLocation.getY();
                    double targetZ = targetLocation.getZ();
                    double verifyUpY = targetY + 1;
                    double goodY;
                    Location doorUpLocation = new Location(e.getPlayer().getWorld(), targetX, verifyUpY, targetZ);

                    if (doorUpLocation.getBlock().getType().toString().contains("DOOR")) {
                        goodY = targetY;
                    } else {
                        goodY = targetY - 1;
                    }
                    String n = "" + String.valueOf(targetX) + "" + String.valueOf(goodY) + "" + String.valueOf(targetZ);
                    String name = n.replaceAll("\\p{Punct}", "");

                    double dYF = instance.getDataLoader().getYByName(name);

                    if (dYF != 0) { //si la position existe
                        String owner = instance.getDataLoader().getOwnerbyName(name);
                        if (owner.equals("06_78//45-jrp87458@@fjfdffhfg145784d")) {

                        } else {
                            if (owner.equals(p.getName())) {

                            } else {
                                e.setCancelled(true);
                                this.messages.getNoPermToUse(p, name, owner);

                            }
                        }
                    }
                }
            }
        }
        if (a.equals(Action.RIGHT_CLICK_BLOCK) && !p.getInventory().getItemInMainHand().getType().equals(Material.STONE_SWORD) && !p.isOp()) {
            if (p.getTargetBlock(null, 100).getType().toString().contains("DOOR")) {
                Location targetLocation = p.getTargetBlock(null, 100).getLocation();
                double targetX = targetLocation.getX();
                double targetY = targetLocation.getY();
                double targetZ = targetLocation.getZ();
                double verifyUpY = targetY + 1;
                double goodY;
                Location doorUpLocation = new Location(e.getPlayer().getWorld(), targetX, verifyUpY, targetZ);

                if (doorUpLocation.getBlock().getType().toString().contains("DOOR")) {
                    goodY = targetY;
                    //p.sendMessage("vous avez cliqué sur le bas de la porte");
                } else {
                    goodY = targetY - 1;
                    //.sendMessage("vous avez cliqué sur le haut de la porte");
                }
                String n = "" + String.valueOf(targetX) + "" + String.valueOf(goodY) + "" + String.valueOf(targetZ);
                String name = n.replaceAll("\\p{Punct}", "");

                double dYF = instance.getDataLoader().getYByName(name);

                if (dYF != 0) { //si la position existe
                    String owner = instance.getDataLoader().getOwnerbyName(name);
                    if (owner.equals("06_78//45-jrp87458@@fjfdffhfg145784d")) {

                    } else {
                        if (owner.equals(p.getName())) {
                        } else {
                            e.setCancelled(true);
                            this.messages.getNoPermToUse(p, name, owner);
                        }
                    }
                }
            }
        }

        if (a.equals(Action.LEFT_CLICK_BLOCK) && !p.isOp()) {
            if (p.getTargetBlock(null, 100).getType().toString().contains("DOOR")) {
                Location targetLocation = p.getTargetBlock(null, 100).getLocation();
                double targetX = targetLocation.getX();
                double targetY = targetLocation.getY();
                double targetZ = targetLocation.getZ();
                double verifyUpY = targetY + 1;
                double goodY;
                Location doorUpLocation = new Location(e.getPlayer().getWorld(), targetX, verifyUpY, targetZ);

                if (doorUpLocation.getBlock().getType().toString().contains("DOOR")) {
                    goodY = targetY;
                } else {
                    goodY = targetY - 1;
                }
                String n = "" + String.valueOf(targetX) + "" + String.valueOf(goodY) + "" + String.valueOf(targetZ);
                String name = n.replaceAll("\\p{Punct}", "");

                double dYF = instance.getDataLoader().getYByName(name);

                if (dYF != 0) { //si la position existe
                    this.messages.getNoPermToBreak(p, name);
                    e.setCancelled(true);
                }
            }
        } else if (p.isOp() && a.equals(Action.LEFT_CLICK_BLOCK)) {
            if (p.getTargetBlock(null, 100).getType().toString().contains("DOOR")) {
                Location targetLocation = p.getTargetBlock(null, 100).getLocation();
                double targetX = targetLocation.getX();
                double targetY = targetLocation.getY();
                double targetZ = targetLocation.getZ();
                double verifyUpY = targetY + 1;
                double goodY;
                Location doorUpLocation = new Location(e.getPlayer().getWorld(), targetX, verifyUpY, targetZ);

                if (doorUpLocation.getBlock().getType().toString().contains("DOOR")) {
                    goodY = targetY;
                } else {
                    goodY = targetY - 1;
                }
                String n = "" + String.valueOf(targetX) + "" + String.valueOf(goodY) + "" + String.valueOf(targetZ);
                String name = n.replaceAll("\\p{Punct}", "");

                double dYF = instance.getDataLoader().getYByName(name);

                if (dYF != 0) { //si la position existe
                    this.messages.getRemoveDoor(p, name);
                    instance.getDataLoader().removeDoor(name);
                }
            }
        }
    }
}