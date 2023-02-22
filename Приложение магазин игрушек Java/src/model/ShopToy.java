package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShopToy {

    private int lastid;
    private List<Toy> shopToy;

    public ShopToy() {
        this.shopToy = new ArrayList<>();
        lastid = 0;
    }

    public void addShopToy(String name, int weight){
        int id = lastid + 1;
        Toy t = new Toy(id, name, weight);
        shopToy.add(t);
        lastid = id;
    }

    public void remove(int idToy){
        if (indexContains(idToy) != -1){
            shopToy.remove(indexContains(idToy));
        }
    }

    private int indexContains(int index) {
        int searchIndex = -1;
        for (Toy t : shopToy) {
            if (t.getId() == index)
                searchIndex = shopToy.indexOf(t);
        }
        return searchIndex;
    }

    public Toy getToyIndex(int index){
        return shopToy.get(index);
    }

    public int count(){
        return shopToy.size();
    }

    public List<Toy> getShopToys(){
        return shopToy;
    }

    public Toy getRandomToy(){
        List<Toy> temp = new ArrayList<>();
        for (Toy t: shopToy) {
            for (int i = 0; i < t.getWeight(); i++) {
                temp.add(t);
            }
        }
        Random rnd = new Random();
        int iTemp = rnd.nextInt(1, temp.size());
        return temp.get(iTemp);
    }

    public void saveResult(String path, List<Toy> temp) {
        try (FileWriter writer = new FileWriter(path, false)) {
            for (Toy toy : temp) {
                writer.append(String.format("id: %s  ", toy.getId()))
                    .append(String.format("name: %s  ", toy.getName()))
                    .append(String.format("weight: %s  ", toy.getWeight()))
                    .append("\n");
                writer.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
