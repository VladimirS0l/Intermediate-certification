package view;

import model.Toy;

import java.util.List;

public interface View {
    public void getShowToys(List<Toy> Toys);
    public void getShowResult(Toy toy, int count);
    public int getToyId();
    public String getToyName();
    public int getToyWeight();
    public void saveResult();
    public void toyAdd();
    public void toyDelete();
    public int countPutResult();
    public void notFoundToy();
    public String choice();
    public void bye();
    public void hello();
}
