package com.emergencyvehicle.util;

import javax.swing.JComboBox;

/**
 * Utility class for validation methods for Emergency Vehicle Management.
 * 
 * Prayash Rawal
 * LMU ID: 23056551
 */
public class ValidationUtil {

    // Validate serial number (integer)
    /**
     * Validates if the input string is a valid serial number.
     *
     * @param input the user input for the serial number
     * @return null if valid, or an error message if invalid
     */
    public static String validateSerialNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Serial numbers cannot be empty."; // Check for empty input
        }
        try {
            int number = Integer.parseInt(input.trim()); // Parse input as an integer
            if (number <= 0) {
                return "Serial number must be a positive integer."; // Check for positive values
            }
        } catch (NumberFormatException e) {
            return "Please enter numeric values for the serial number."; // Handle invalid numeric input
        }
        return null; // Input is valid
    }

    // Validate model number
    /**
     * Validates if the model number is valid.
     *
     * @param modelNumber the model number to validate
     * @return null if valid, or an error message if invalid
     */
    public static String validateModelNumber(String modelNumber) {
        if (modelNumber == null || modelNumber.trim().isEmpty()) {
            return "Model numbers cannot be empty.";
        }
        if (!modelNumber.trim().matches("[a-zA-Z0-9]+")) {
            return "Model number must be alphanumeric.";
        }
        return null; // Input is valid
    }

    // Validate vehicle name
    /**
     * Validates if the vehicle name is valid.
     *
     * @param vehicleName the vehicle name to validate
     * @return null if valid, or an error message if invalid
     */
    public static String validateVehicleName(String vehicleName) {
        if (vehicleName == null || vehicleName.trim().isEmpty()) {
            return "Vehicle names cannot be empty.";
        }
        if (!vehicleName.trim().matches("[a-zA-Z0-9 ]+")) { // Allow spaces for vehicle names like "Ambulance 101"
            return "Vehicle name must be alphanumeric and can contain spaces.";
        }
        return null; // Input is valid
    }

    // Validate price (integer, greater than 1000)
    /**
     * Validates if the price is valid.
     *
     * @param input the price to validate
     * @return null if valid, or an error message if invalid
     */
    public static String validatePrice(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Prices cannot be empty."; // Check for empty input
        }
        try {
            int price = Integer.parseInt(input.trim()); // Parse the input as an integer
            if (price <= 1000) {
                return "Price must be greater than 1000."; // Check for price greater than 1000
            }
        } catch (NumberFormatException e) {
            return "Price must be numeric."; // Handle invalid numeric input
        }
        return null; // Input is valid
    }

    // Validate Emergency Vehicle Type (for ComboBox selection)
    /**
     * Validates if the emergency vehicle type selected from ComboBox is valid.
     *
     * @param vehicleTypeComboBox the ComboBox containing vehicle types
     * @return null if valid, or an error message if invalid
     */
    public static String validateEmergencyVehicleType(JComboBox<String> vehicleTypeComboBox) {
        // Get the selected item from ComboBox
        String vehicleType = (String) vehicleTypeComboBox.getSelectedItem();

        // Check if the selected item is null or empty
        if (vehicleType == null || vehicleType.trim().isEmpty()) {
            return "Vehicle type cannot be empty. Please choose a valid option."; // Ensure a vehicle type is selected
        }

        // Array of valid vehicle types
        String[] validTypes = {"Ambulance", "Fire Truck", "Police Car"};

        // Check if the selected vehicle type is valid
        for (String validType : validTypes) {
            if (validType.equalsIgnoreCase(vehicleType.trim())) {
                return null; // Valid type found
            }
        }

        // Return an error message if the vehicle type is invalid
        return "Invalid vehicle type. Please choose a valid emergency vehicle type.";
    }

    // Validate Availability Status (for ComboBox selection)
    /**
     * Validates if the availability status selected from ComboBox is valid.
     *
     * @param statusComboBox the ComboBox containing availability statuses
     * @return null if valid, or an error message if invalid
     */
    public static String validateAvailabilityStatus(JComboBox<String> statusComboBox) {
        // Get the selected item from ComboBox
        String status = (String) statusComboBox.getSelectedItem();

        // Check if the selected item is null, empty or the default "Please select"
        if (status == null || status.trim().isEmpty()) {
            return "Availability status cannot be empty. Please select a valid option."; // Ensure availability status is selected
        }

        // Array of valid statuses
        String[] validStatuses = {"Available", "Unavailable"};

        // Check if the selected status is valid
        for (String validStatus : validStatuses) {
            if (validStatus.equalsIgnoreCase(status.trim())) {
                return null; // Valid status
            }
        }

        // Return an error message if the availability status is invalid
        return "Invalid availability status. Please choose from: Available, Unavailable.";
    }

    // Validate current Location (for ComboBox selection)
    /**
     * Validates if the location selected from ComboBox is valid.
     *
     * @param cbLocation the ComboBox containing locations
     * @return null if valid, or an error message if invalid
     */
    public static String validateLocation(JComboBox<String> cbLocation) {
        // Get the selected item from ComboBox
        String location = (String) cbLocation.getSelectedItem();

        // Check if the selected item is null, empty, or invalid (e.g., "Please select")
        if (location == null || location.trim().isEmpty()) {
            return "Location cannot be empty. Please select a valid option."; // Ensure a valid location is selected
        }

        // Return null if the location is valid
        return null;
    }
}
