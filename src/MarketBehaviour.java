import java.util.List;

public interface MarketBehaviour {
    void acceptToMarket(Actor actor); // зашел в магазин
    void releaseFromMarket(); // вышел из магазина
    void update(int index);  // обновление
}
