package presenter;
import model.ShopToy;
import model.Toy;
import view.ConsoleView;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Presenter {
    private ShopToy st;
    private ConsoleView view;

    public Presenter() {
        st = new ShopToy();
        view = new ConsoleView();
    }

    public void addToy(){
        st.addShopToy(view.getToyName(), view.getToyWeight());
    }

    public void deleteToy(){
        showAll();
        int idDelete = view.getToyId();
        if (st.count() != 0 && st.count() >= idDelete){
            st.remove(idDelete);
            view.toyDelete();
        }else {
            view.notFoundToy();
        }
    }

    public void showAll(){
        view.getShowToys(st.getShopToys());
    }

    public void getRoll() {
        PriorityQueue<Toy> pq = new PriorityQueue<Toy>();
        List<Toy> forDb = new ArrayList<>();
        Toy temp;
        int countRole = view.countPutResult();
        for (int i = 0; i < countRole; i++) {
            pq.add(st.getRandomToy());
        }
        for (int i = 0; i < countRole; i++) {
            temp = pq.poll();
            view.getShowResult(temp, i);
            forDb.add(temp);
        }
        st.saveResult(Config.pathDb, forDb);
        view.saveResult();
    }
}
