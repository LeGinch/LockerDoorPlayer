package fr.rockxenam.lockerdoorplayer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class DataFile {
    private LockerDoorPlayer instance;

    private File file;

    protected FileConfiguration config;

    private List<String> empty = new ArrayList<>();

    private List<String> positions = new ArrayList<>();

    public DataFile(LockerDoorPlayer instance) {
        this.instance = instance;
    }

    public void save() {
        try {
            this.config.save(this.file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create() {
        this.file = new File(this.instance.getDataFolder(), "datafile.yml");
        if (!this.file.exists())
            try {
                this.file.createNewFile();
                this.save();

            } catch (IOException e) {
                e.printStackTrace();
            }
        this.config = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);


        save();
    }

    public double getXByName(String name){
        Object value_X = null;
        value_X = this.config.get(name +".position.x");
        if(value_X != null){
            double intX = (double) value_X;
            return intX;
        }
        return 0;
    }

    public double getYByName(String name){
        Object value_Y = null;
        value_Y = this.config.get(name +".position.y");
        if(value_Y != null){
            double intY = (double) value_Y;
            return intY;
        }
        return 0;
    }

    public double getZByName(String name){
        Object value_Z = null;
        value_Z = this.config.get(name +".position.z");
        if(value_Z != null){
            double intZ = (double) value_Z;
            return intZ;
        }
        return 0;
    }

    public String getOwnerbyName(String name){
        Object value = null;
        value = this.config.get(name +".owner");
        if(value != null){
            String i = value.toString();
            return i;
        }
        return "06_78//45-jrp87458@@fjfdffhfg145784d";
    }

    public void addDoor(String name, double x, double y, double z){
            this.config.set(String.valueOf(name) + ".position.x",x);
            this.config.set(String.valueOf(name) + ".position.y", y);
            this.config.set(String.valueOf(name) + ".position.z", z);
            this.positions.add(String.valueOf(name));
            save();
    }

    public void removeDoor(String name){
        this.config.set(name, null);
        this.positions.remove(name);
        save();
    }

    public void addOwner(String name , String owner){
        this.config.set(String.valueOf(name) + ".owner",owner);
        save();
    }

    public void removeOwner(String name){
        this.config.set(String.valueOf(name) + ".owner",null);
        save();

    }

}
