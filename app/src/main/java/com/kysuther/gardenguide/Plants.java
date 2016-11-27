package com.kysuther.gardenguide;

/**
 * Created by cry on 2016-11-25.
 */


public class Plants {

    public String name;
    public Integer plant;
    public Plants(String name, Integer plant){
        super();
        this.name = name;
        this.plant = plant;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPlant() {
        return plant;
    }
    public void setPlant(Integer price) {
        this.plant = plant;
    }

}