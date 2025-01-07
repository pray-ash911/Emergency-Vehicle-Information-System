package com.emergencyvehicle.controller.algorithms;

import com.emergencyvehicle.model.EmergencyVehicle;
import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public List<EmergencyVehicle> searchByType(String searchValue, List<EmergencyVehicle> vehicleList, int left, int right) {
        List<EmergencyVehicle> results = new ArrayList<>();
        if (left > right) {
            return results;
        }

        int mid = (left + right) / 2;
        int cmp = searchValue.compareToIgnoreCase(vehicleList.get(mid).getVehicleType());

        System.out.println("Searching for: " + searchValue + " at index: " + mid + " with vehicle type: " + vehicleList.get(mid).getVehicleType());

        if (cmp == 0) {
            results.add(vehicleList.get(mid));
            results.addAll(searchByType(searchValue, vehicleList, left, mid - 1));
            results.addAll(searchByType(searchValue, vehicleList, mid + 1, right));
        } else if (cmp < 0) {
            return searchByType(searchValue, vehicleList, left, mid - 1);
        } else {
            return searchByType(searchValue, vehicleList, mid + 1, right);
        }
        return results;
    }

    public List<EmergencyVehicle> searchByNumber(String searchValue, List<EmergencyVehicle> vehicleList, int left, int right) {
        List<EmergencyVehicle> results = new ArrayList<>();
        if (left > right) {
            return results;
        }

        int mid = (left + right) / 2;
        int cmp = searchValue.compareToIgnoreCase(vehicleList.get(mid).getEmergencyVehicleName());

        System.out.println("Searching for: " + searchValue + " at index: " + mid + " with vehicle number: " + vehicleList.get(mid).getEmergencyVehicleName());

        if (cmp == 0) {
            results.add(vehicleList.get(mid));
            results.addAll(searchByNumber(searchValue, vehicleList, left, mid - 1));
            results.addAll(searchByNumber(searchValue, vehicleList, mid + 1, right));
        } else if (cmp < 0) {
            return searchByNumber(searchValue, vehicleList, left, mid - 1);
        } else {
            return searchByNumber(searchValue, vehicleList, mid + 1, right);
        }
        return results;
    }
}
