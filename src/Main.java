public class Main {
    public static void main(String[] args) {
        System.out.println("HW2");
        Human human1 = new Human("Вася");
        Human human2 = new Human("Петя");
        Market market = new Market();
        market.acceptToMarket(human1);
        market.takeInQueue(human1);
        market.acceptToMarket(human2);
        market.takeInQueue(human2);
        market.takeOrders();
        market.takeOrders();
        market.giveOrders();
        market.releaseFromQueue();
        market.releaseFromMarket();
        market.giveOrders();
        market.takeOrders();
        market.giveOrders();
        market.releaseFromQueue();
        market.releaseFromMarket();
    }
}