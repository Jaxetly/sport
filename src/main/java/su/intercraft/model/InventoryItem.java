package su.intercraft.model;

public class InventoryItem {
    private int id;
    private String name;
    private String parameters;
    private int age;
    private String placementConditions;

    public InventoryItem(int id, String name, String parameters, int age, String placementConditions) {
        this.id = id;
        this.name = name;
        this.parameters = parameters;
        this.age = age;
        this.placementConditions = placementConditions;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlacementConditions() {
        return placementConditions;
    }

    public void setPlacementConditions(String placementConditions) {
        this.placementConditions = placementConditions;
    }
}
