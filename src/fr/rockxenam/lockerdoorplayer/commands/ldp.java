package fr.rockxenam.lockerdoorplayer.commands;

import fr.rockxenam.lockerdoorplayer.LockerDoorPlayer;
import fr.rockxenam.lockerdoorplayer.messages.consoleMessages;
import fr.rockxenam.lockerdoorplayer.messages.playerMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ldp implements CommandExecutor {
    private LockerDoorPlayer instance;

    private playerMessages playerMessages;
    private consoleMessages consoleMessages;
    public ldp(LockerDoorPlayer instance) {

        this.instance = instance;

        playerMessages = new playerMessages(instance);

        consoleMessages= new consoleMessages(instance);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.isOp()){
                if(cmd.getName().equalsIgnoreCase("ldp")) {
                    if(arg.length == 0){
                        this.playerMessages.getCommandToShort(player);
                    } else {
                        if(arg.length == 2){
                            if(arg[0].equalsIgnoreCase("removeowner")) {
                                String doorName = arg[1];
                                double dYF = instance.getDataLoader().getYByName(doorName);
                                if(dYF == 0){ //si la position existe
                                    this.playerMessages.getDoorDoesNotExist(player, doorName);
                                } else {
                                        String OwnerByName = instance.getDataLoader().getOwnerbyName(doorName);

                                    if(OwnerByName.equals("06_78//45-jrp87458@@fjfdffhfg145784d")){
                                        this.playerMessages.getOwnerDoesNotExist(player, doorName);
                                    } else {
                                        this.playerMessages.getOwnerUnset(player, doorName ,OwnerByName);
                                        instance.getDataLoader().removeOwner(doorName);

                                    }
                                    return true;
                                }
                            } else {
                               this.playerMessages.getCommandIsNotRemove(player);
                            }
                        }
                         else if(arg.length == 3){
                            if(arg[0].equalsIgnoreCase("addowner")) {
                                String doorName = arg[1];
                                double dYF = instance.getDataLoader().getYByName(doorName);
                                if(dYF == 0){ //si la position existe
                                    this.playerMessages.getDoorDoesNotExist(player, doorName);
                                } else {
                                    String playerName = arg[2];

                                    this.playerMessages.getOwnerset(player, doorName, playerName);

                                    instance.getDataLoader().addOwner(doorName, playerName);
                                    return true;
                                }
                            } else {
                                this.playerMessages.getCommandIsNotAdd(player);
                            }
                        }
                        else if(arg.length == 1){
                            this.playerMessages.getCommandToShort(player);
                        } else if(arg.length >= 4){
                            this.playerMessages.getCommandToLong(player);

                        }
                    }
                }
            } else {
                this.playerMessages.getNoAccessCommand(player);
            }
        } else {
            if(cmd.getName().equalsIgnoreCase("ldp")) {
                if(arg.length == 0){
                    this.consoleMessages.getCommandToShort();
                } else {
                    if(arg.length == 2){
                        if(arg[0].equalsIgnoreCase("removeowner")) {
                            String doorName = arg[1];
                            double dYF = instance.getDataLoader().getYByName(doorName);
                            if(dYF == 0){ //si la position existe
                                this.consoleMessages.getDoorDoesNotExist(doorName);
                            } else {
                                String OwnerByName = instance.getDataLoader().getOwnerbyName(doorName);

                                if(OwnerByName.equals("06_78//45-jrp87458@@fjfdffhfg145784d")){
                                    this.consoleMessages.getOwnerDoesNotExist(doorName);
                                } else {
                                    this.consoleMessages.getOwnerUnset(doorName ,OwnerByName);
                                    instance.getDataLoader().removeOwner(doorName);

                                }
                                return true;
                            }
                        } else {
                            this.consoleMessages.getCommandIsNotRemove();
                        }
                    }
                    else if(arg.length == 3){
                        if(arg[0].equalsIgnoreCase("addowner")) {
                            String doorName = arg[1];
                            double dYF = instance.getDataLoader().getYByName(doorName);
                            if(dYF == 0){ //si la position existe
                                this.consoleMessages.getDoorDoesNotExist(doorName);
                            } else {
                                String playerName = arg[2];

                                this.consoleMessages.getOwnerset(doorName, playerName);

                                instance.getDataLoader().addOwner(doorName, playerName);
                                return true;
                            }
                        } else {
                            this.consoleMessages.getCommandIsNotAdd();
                        }
                    }
                    else if(arg.length == 1){
                        this.consoleMessages.getCommandToShort();
                    } else if(arg.length >= 4){
                        this.consoleMessages.getCommandToLong();

                    }
                }
            }
        }
        return false;
    }


}
