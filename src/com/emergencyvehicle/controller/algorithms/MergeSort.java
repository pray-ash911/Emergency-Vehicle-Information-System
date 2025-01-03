
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergencyvehicle.controller.algorithms;

import com.emergencyvehicle.model.EmergencyVehicle;
import java.util.ArrayList;
import java.util.List;

/*
 * Prayash Rawal
 * LMU ID: 23056551
 */

public class MergeSort {

    /**
     * Sorts a list of EmergencyVehicle objects by their emergency vehicle name in ascending or
     * descending order.
     *
     * @param vehicleList the list of EmergencyVehicle objects to be sorted
     * @param descending specifies the sort order (true for descending, false for ascending)
     * @return the sorted list
     */
    public static List<EmergencyVehicle> sortByVehicleName(List<EmergencyVehicle> vehicleList, boolean descending) {
        if (vehicleList.size() <= 1) {
            return vehicleList; // Base case
        }

        // Divide the list into two halves
        int mid = vehicleList.size() / 2;
        List<EmergencyVehicle> left = new ArrayList<>(vehicleList.subList(0, mid));
        List<EmergencyVehicle> right = new ArrayList<>(vehicleList.subList(mid, vehicleList.size()));

        // Recursively sort both halves
        left = sortByVehicleName(left, descending);
        right = sortByVehicleName(right, descending);

        // Merge the sorted halves
        return merge(left, right, descending);
    }

    /**
     * Helper method to merge two sorted lists
     *
     * @param left the left half of the list to be merged
     * @param right the right half of the list to be merged
     * @param descending specifies the sort order (true for descending, false for ascending)
     * @return the merged list
     */
    private static List<EmergencyVehicle> merge(List<EmergencyVehicle> left, List<EmergencyVehicle> right, boolean descending) {
        List<EmergencyVehicle> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            String leftName = left.get(i).getEmergencyVehicleName();
            String rightName = right.get(j).getEmergencyVehicleName();
            
            // Perform case-insensitive comparison
            int comparison = descending ? rightName.compareToIgnoreCase(leftName) : leftName.compareToIgnoreCase(rightName);

            if (comparison <= 0) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        // Add remaining elements from the left list
        while (i < left.size()) {
            merged.add(left.get(i++));
        }
        // Add remaining elements from the right list
        while (j < right.size()) {
            merged.add(right.get(j++));
        }

        return merged;
    }
}
