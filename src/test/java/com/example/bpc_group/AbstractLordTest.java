package com.example.bpc_group;

import com.example.bpc_group.models.entity.Lord;
import com.example.bpc_group.models.entity.Planet;

import java.util.ArrayList;
import java.util.List;

public class AbstractLordTest {

    protected List<Planet> generatePlanetList(int l, int p){
        List<Planet> result = new ArrayList<>();
        List<Lord> lordList =  generateLordList(l);
        for (int j = 1; j < p+1; j++) {
            Planet planet = new Planet();
            planet.setLord(lordList.get(j));
            result.add(planet);
        }
        return result;
    }

    protected List<Lord> generateLordList(int i) {
        List<Lord> result = new ArrayList<>();
        for (int j = 1; j < i+1; j++) {
            Lord lord = new Lord();
            lord.setId(j);
            lord.setName("name" + j);
            result.add(lord);
        }
        return result;
    }


}
