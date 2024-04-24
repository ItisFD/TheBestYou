package edu.utsa.cs3773.thebestyou.model;

public class UserProfile {
    private String email; // Add email field
    private String password; // Add password field
    private int age;
    private String gender;
    private int heightInches;
    private float weight;
    private float targetWeight;
    private String frequency;
    private String level;

    // Constructor
    public UserProfile(int age, String gender, int heightInches, float weight, float targetWeight, String frequency, String level) {
        this.age = age;
        this.gender = gender;
        this.heightInches = heightInches;
        this.weight = weight;
        this.targetWeight = targetWeight;
        this.frequency = frequency;
        this.level = level;
    }

    // Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(int heightInches) {
        this.heightInches = heightInches;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(float targetWeight) {
        this.targetWeight = targetWeight;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    // Add setter methods for email and password
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
