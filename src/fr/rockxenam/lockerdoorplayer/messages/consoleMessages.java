package fr.rockxenam.lockerdoorplayer.messages;

import fr.rockxenam.lockerdoorplayer.LockerDoorPlayer;
import org.bukkit.entity.Player;

public class consoleMessages {

    private LockerDoorPlayer ldp;

    public consoleMessages(LockerDoorPlayer ldp){
        this.ldp = ldp;
    }

    private String replaceDoorinMsg(String msg, String doorName){
        String str = msg;

        int i = str.indexOf("XdoorX");


        if(i == - 1){
            return msg;

        } else {
            String msg2 = msg.replace("XdoorX", doorName);

            return msg2;
        }
    }

    private String replaceOwnerinMsg(String msg, String playerName){
        String str = msg;

        int i = str.indexOf("XownerX");


        if(i == - 1){
            return msg;

        } else {
            String msg2 = msg.replace("XownerX", playerName);

            return msg2;
        }
    }

    private String getPrefix(){
        String p = ldp.getConfig().getString("messages.prefix");

        if(p.isEmpty()){
            return "false";

        } else {
            return p + " ";
        }
    }

    private String getPrefixActivated(String name){
        String result = ldp.getConfig().getString("messages.player." + name + ".prefix");

        return result;
    }


    public void getEnable(){
        String e = ldp.getConfig().getString("messages.plugin.enable");
        if(e.equals("true")){
            String msg = ldp.getConfig().getString("messages.plugin.start");
            if(getPrefix().equals("false")){
                System.out.println(msg);

            } else {
                String pr = getPrefix();

                String msg2 = pr + msg;

                System.out.println(msg2);
            }
        }
    }

    public void getDisable(){
        String e = ldp.getConfig().getString("messages.plugin.enable");
        if(e.equals("true")){
            String msg = ldp.getConfig().getString("messages.plugin.stop");
            if(getPrefix().equals("false")){
                System.out.println(msg);

            } else {
                String pr = getPrefix();

                msg = pr + msg;

                System.out.println(msg);

            }
        }
    }
    public void getDoorExist(String doorName){
        String e = ldp.getConfig().getString("messages.player.doorexist.enable");
        if(e.equals("true")){
            String msg = ldp.getConfig().getString("messages.player.doorexist.message");

            if(getPrefix().equals("false")){
                String msg2 = replaceDoorinMsg(msg, doorName);
                System.out.println(msg2);
            } else {
                String res = getPrefixActivated("doorexist");
                if(res.equals("true")){
                    String pr = getPrefix();
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    String msg3 = pr + msg2;
                    System.out.println(msg3);
                } else {
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    System.out.println(msg2);
                }
            }
        }
    }

    public void getSetDoor(String doorName){
        String e = ldp.getConfig().getString("messages.player.setdoor.enable");
        if(e.equals("true")){
            String msg = ldp.getConfig().getString("messages.player.setdoor.message");
            if(getPrefix().equals("false")){
                String msg2 = replaceDoorinMsg(msg, doorName);
                System.out.println(msg2);
            } else {
                String res = getPrefixActivated("setdoor");
                if(res.equals("true")){
                    String pr = getPrefix();
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    String msg3 = pr + msg2;
                    System.out.println(msg3);
                } else{
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    System.out.println(msg2);
                }
            }
        }
    }

    public void getRemoveDoor(String doorName){
        String e = ldp.getConfig().getString("messages.player.removedoor.enable");
        if(e.equals("true")){
            String msg = ldp.getConfig().getString("messages.player.removedoor.message");
            if(getPrefix().equals("false")){
                String msg2 = replaceDoorinMsg(msg, doorName);
                System.out.println(msg2);
            } else {
                String res = getPrefixActivated("removedoor");
                if(res.equals("true")){
                    String pr = getPrefix();
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    String msg3 = pr + msg2;
                    System.out.println(msg3);
                } else{
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    System.out.println(msg2);
                }
            }
        }
    }

    public void getDoorDoesNotExist(String doorName){
        String e = ldp.getConfig().getString("messages.player.doordoesnotexist.enable");
        if(e.equals("true")){
            String msg = ldp.getConfig().getString("messages.player.doordoesnotexist.message");
            if(getPrefix().equals("false")){
                String msg2 = replaceDoorinMsg(msg, doorName);
                System.out.println(msg2);
            } else {
                String res = getPrefixActivated("doordoesnotexist");
                if(res.equals("true")){
                    String pr = getPrefix();
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    String msg3 = pr + msg2;
                    System.out.println(msg3);
                } else{
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    System.out.println(msg2);
                }
            }
        }
    }

    public void getNoPermToBreak(Player p, String doorName){
        String e = ldp.getConfig().getString("messages.player.nopermtobreak.enable");
        if(e.equals("true")){
            String msg = ldp.getConfig().getString("messages.player.nopermtobreak.message");

            if(getPrefix().equals("false")){
                String msg2 = replaceDoorinMsg(msg, doorName);
                p.sendMessage(msg2);

            } else {
                String res = getPrefixActivated("nopermtobreak");
                if(res.equals("true")){
                    String pr = getPrefix();
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    String msg3 = pr + msg2;
                    p.sendMessage(msg3);
                } else{
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    p.sendMessage(msg2);
                }

            }
        }
    }

    public void getNoPermToUse(String doorName, String Owner){
        String e = ldp.getConfig().getString("messages.player.nopermtouse.enable");
        if(e.equals("true")){
            String msg = ldp.getConfig().getString("messages.player.nopermtouse.message");
            if(getPrefix().equals("false")){
                String msg2 = replaceDoorinMsg(msg, doorName);
                String msg3 = replaceOwnerinMsg(msg2, Owner);
                System.out.println(msg3);
            } else {
                String res = getPrefixActivated("nopermtouse");
                if(res.equals("true")){
                    String pr = getPrefix();
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    String msg3 = replaceOwnerinMsg(msg2, Owner);

                    String msg4 = pr + msg3;
                    System.out.println(msg4);
                } else{
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    String msg3 = replaceOwnerinMsg(msg2, Owner);
                    System.out.println(msg3);
                }
            }
        }
    }

    public void getCommandToShort(){
        String e = ldp.getConfig().getString("messages.player.commandtoshort.enable");
        if(e.equals("true")){
            String msg01 = ldp.getConfig().getString("messages.player.commandtoshort.message01");
            String msg02 = ldp.getConfig().getString("messages.player.commandtoshort.message02");
            String msg03 = ldp.getConfig().getString("messages.player.commandtoshort.message03");
            if(getPrefix().equals("false")){
                System.out.println(msg01);
                System.out.println(msg02);
                System.out.println(msg03);
            } else {
                String res = getPrefixActivated("commandtoshort");
                if(res.equals("true")){
                    String pr = getPrefix();
                    String msg011 = pr + msg01;
                    String msg021 = pr + msg02;
                    String msg031 = pr + msg03;
                    System.out.println(msg011);
                    System.out.println(msg021);
                    System.out.println(msg031);
                } else {
                    System.out.println(msg01);
                    System.out.println(msg02);
                    System.out.println(msg03);
                }
            }
        }
    }

    public void getNoAccessCommand(){
        String e = ldp.getConfig().getString("messages.player.noaccesscommand.enable");
        if(e.equals("true")){
            String msg = ldp.getConfig().getString("messages.player.noaccesscommand.message");
            if(getPrefix().equals("false")){
                System.out.println(msg);
            } else {
                String res = getPrefixActivated("noaccesscommand");
                if(res.equals("true")){
                    String pr = getPrefix();
                    String msg01 = pr + msg;
                    System.out.println(msg01);
                } else{
                    System.out.println(msg);
                }
            }
        }
    }

    public void getCommandToLong(){
        String e = ldp.getConfig().getString("messages.player.commandtolong.enable");
        if(e.equals("true")){
            String msg01 = ldp.getConfig().getString("messages.player.commandtolong.message01");
            String msg02 = ldp.getConfig().getString("messages.player.commandtolong.message02");
            String msg03 = ldp.getConfig().getString("messages.player.commandtolong.message03");

            if(getPrefix().equals("false")){
                System.out.println(msg01);
                System.out.println(msg02);
                System.out.println(msg03);
            } else {
                String res = getPrefixActivated("commandtolong");
                if(res.equals("true")){
                    String pr = getPrefix();
                    String msg011 = pr + msg01;
                    String msg021 = pr + msg02;
                    String msg031 = pr + msg03;
                    System.out.println(msg011);
                    System.out.println(msg021);
                    System.out.println(msg031);
                } else{
                    System.out.println(msg01);
                    System.out.println(msg02);
                    System.out.println(msg03);
                }
            }
        }
    }

    public void getCommandIsNotRemove(){
        String e = ldp.getConfig().getString("messages.player.commandisnotremove.enable");
        if(e.equals("true")){
            String msg01 = ldp.getConfig().getString("messages.player.commandisnotremove.message01");
            String msg02 = ldp.getConfig().getString("messages.player.commandisnotremove.message02");

            if(getPrefix().equals("false")){
                System.out.println(msg01);
                System.out.println(msg02);
            } else {
                String res = getPrefixActivated("commandisnotremove");
                if(res.equals("true")){
                    String pr = getPrefix();
                    String msg011 = pr + msg01;
                    String msg021 = pr + msg02;
                    System.out.println(msg011);
                    System.out.println(msg021);
                } else{
                    System.out.println(msg01);
                    System.out.println(msg02);
                }
            }
        }
    }

    public void getCommandIsNotAdd(){
        String e = ldp.getConfig().getString("messages.player.commandisnotadd.enable");
        if(e.equals("true")){
            String msg01 = ldp.getConfig().getString("messages.player.commandisnotadd.message01");
            String msg02 = ldp.getConfig().getString("messages.player.commandisnotadd.message02");
            if(getPrefix().equals("false")){
                System.out.println(msg01);
                System.out.println(msg02);
            } else {
                String res = getPrefixActivated("commandisnotadd");
                if(res.equals("true")){
                    String pr = getPrefix();
                    String msg011 = pr + msg01;
                    String msg021 = pr + msg02;
                    System.out.println(msg011);
                    System.out.println(msg021);
                } else{
                    System.out.println(msg01);
                    System.out.println(msg02);
                }
            }
        }
    }

    public void getOwnerUnset(String doorName, String Owner){
        String e = ldp.getConfig().getString("messages.player.ownerunset.enable");
        if(e.equals("true")){
            String msg = ldp.getConfig().getString("messages.player.ownerunset.message");

            if(getPrefix().equals("false")){
                String msg2 = replaceDoorinMsg(msg, doorName);
                String msg3 = replaceOwnerinMsg(msg2, Owner);
                System.out.println(msg3);
            } else {
                String res = getPrefixActivated("ownerunset");
                if(res.equals("true")){
                    String pr = getPrefix();
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    String msg3 = replaceOwnerinMsg(msg2, Owner);
                    String msg4 = pr + msg3;
                    System.out.println(msg4);
                } else{
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    String msg3 = replaceOwnerinMsg(msg2, Owner);
                    System.out.println(msg3);
                }
            }
        }
    }

    public void getOwnerset(String doorName, String Owner){
        String e = ldp.getConfig().getString("messages.player.ownerset.enable");
        if(e.equals("true")){
            String msg = ldp.getConfig().getString("messages.player.ownerset.message");
            if(getPrefix().equals("false")){
                String msg2 = replaceDoorinMsg(msg, doorName);
                String msg3 = replaceOwnerinMsg(msg2, Owner);
                System.out.println(msg3);
            } else {
                String res = getPrefixActivated("ownerset");
                if(res.equals("true")){
                    String pr = getPrefix();
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    String msg3 = replaceOwnerinMsg(msg2, Owner);
                    String msg4 = pr + msg3;
                    System.out.println(msg4);
                } else{
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    String msg3 = replaceOwnerinMsg(msg2, Owner);
                    System.out.println(msg3);
                }
            }
        }
    }

    public void getOwnerDoesNotExist(String doorName){
        String e = ldp.getConfig().getString("messages.player.ownerdoesnotexist.enable");
        if(e.equals("true")){
            String msg = ldp.getConfig().getString("messages.player.ownerdoesnotexist.message");
            if(getPrefix().equals("false")){
                String msg2 = replaceDoorinMsg(msg, doorName);
                System.out.println(msg2);
            } else {
                String res = getPrefixActivated("ownerdoesnotexist");
                if(res.equals("true")){
                    String pr = getPrefix();
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    String msg3 = pr + msg2;
                    System.out.println(msg3);

                } else {
                    String msg2 = replaceDoorinMsg(msg, doorName);
                    System.out.println(msg2);

                }
            }
        }
    }
}