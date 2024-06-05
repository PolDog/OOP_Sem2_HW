public interface MarketBehaviour {
    void acceptToMarket(Actor actor); // зашел в магазин
    void releaseFromMarket(); // вышел из магазина
    void update();  // обновление
}
