package application;

import entity.*;
import dao.*;

public class DeviceApp {

    public static void main(String[] args) {

        // To run the project
        // remember to change the password value in sersistence.xml file
    	
    	Dao dao = new Dao();
    	
        Device d1 = new Device("Dell Latitude 7490");
        dao.saveDevice(d1);
        System.out.println("Device saved.");

        // forget the device l1
        d1 = null;

        // retrieve device by id
        d1 = dao.loadDevice(1);
        System.out.println(d1);

        // update device description
        if(dao.updateDeviceDescription(d1.getDeviceId(), "Macbook pro 15 inch 2018")){
            System.out.println("Device updated successfully!");
        }else{
            System.out.println("Device not found!");
        }

        // add device d2
        Device d2 = new Device("Asus 3960");
        dao.saveDevice(d2);

        // remove device d2
        if(dao.removeDevice(d2.getDeviceId())){
            System.out.println("Device " + d2.getDescription() + " removed successfully!");
        }else{
            System.out.println("Device not found!");
        }


    }
}

