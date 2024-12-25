package com.collegeapp.controller.datastructure;

import com.courseWork.model.EmergencyVehicle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class VehicleManager {

    // Data structures for managing emergency vehicles
    private static ArrayList<EmergencyVehicle> emergencyVehicles = new ArrayList<>();
    private static LinkedList<String> dispatchRecords = new LinkedList<>();
    private static Stack<EmergencyVehicle> dispatchedVehicles = new Stack<>();
    private static Queue<String> serviceRequests = new LinkedList<>();

    // Method to add a vehicle
    public static void addVehicle(EmergencyVehicle vehicle) {
        emergencyVehicles.add(vehicle);  // Add vehicle to ArrayList
        System.out.println("Vehicle added: " + vehicle); // Debugging

    }
    
    // Method to retrieve all vehicles
    public static ArrayList<EmergencyVehicle> getAllVehicles() {
        System.out.println("Vehicle list: " + emergencyVehicles); // Debugging
        return emergencyVehicles;  // Return the list of vehicles
    }
    
    public static boolean deleteVehicle(int serialNumber) {
    for (EmergencyVehicle vehicle : emergencyVehicles) {
        if (vehicle.getSerialNumber() == serialNumber) { // Compare integers
            emergencyVehicles.remove(vehicle); // Remove the vehicle
            return true; // Vehicle deleted successfully
        }
    }
    return false; // Vehicle not found
}

    
    

    // Method to add dispatch record
    public static void addDispatchRecord(String record) {
        dispatchRecords.add(record);  // Add record to LinkedList
    }

    // Method to dispatch vehicle
    public static void dispatchVehicle(EmergencyVehicle vehicle) {
        dispatchedVehicles.push(vehicle);  // Push to Stack
    }

    // Method to add service request
    public static void addServiceRequest(String request) {
        serviceRequests.add(request);  // Add to Queue
    }

    // Other relevant methods...
}
