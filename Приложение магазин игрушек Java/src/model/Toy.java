package model;

public class Toy implements Comparable<Toy>{
    private int id;
    private String name;
    private int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public Toy(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Toy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Идентификатор: " + id +
                ", Имя: '" + name + '\'' +
                ", Частота выпадения: " + weight;
    }

    @Override
    public int compareTo(Toy o) {
        return o.getWeight() - this.getWeight();
    }
}
