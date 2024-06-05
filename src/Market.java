import java.util.ArrayList;
import java.util.List;
public class Market implements MarketBehaviour, QueueBehaviour {
    private List<Actor> actors;
    private List<Actor> queue;
    private final int NO_ORDER = 0;
    private final int NOT_TAKE = 1;
    private final int ENTER_MARKET = 2;
    private final int ENTER_QUEUE = 3;
    private final int MAKE_ORDER = 4;
    private final int TAKE_ORDER = 5;
    private final int LEAVE_QUEUE = 6;
    private final int LEAVE_MARKET = 7;
    private final int ERROR_TAKE = 8;
    private final int ZERO_QUEUE = -1;

    public Market() {
        actors = new ArrayList<>();
        queue = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        actors.add(actor);
        update(ENTER_MARKET);
    }

    @Override
    public void releaseFromMarket() {
        update(LEAVE_MARKET);
        actors.remove(0);
    }

    @Override
    public void update(int index) {
        switch (index) {
            case NO_ORDER:
                System.out.println(queue.get(0).getName() + " заказ не сделал!");
                break;
            case NOT_TAKE:
                System.out.println(queue.get(0).getName() + " заказ не получил!");
                break;
            case ENTER_MARKET:
                System.out.println(actors.getLast().getName() + " вошел в магазин");
                System.out.println("        В магазине " + actors.size() + " человек");
                break;
            case ENTER_QUEUE:
                System.out.println(queue.getLast().getName() + " встал в очередь");
                System.out.println("        Размер очереди " + queue.size());
                break;
            case MAKE_ORDER:
                System.out.println(queue.get(0).getName() + " сделал заказ");
                break;
            case TAKE_ORDER:
                System.out.println(queue.get(0).getName() + " получил заказ");
                break;
            case LEAVE_QUEUE:
                System.out.println(queue.get(0).getName() + " покинул очередь");
                System.out.println("        Размер очереди " + (queue.size() - 1));
                break;
            case LEAVE_MARKET:
                System.out.println(actors.get(0).getName() + " покинул магазин");
                System.out.println("        В магазине " + (actors.size() - 1) + " человек");
                break;
            case ERROR_TAKE:
                System.out.println("Нельзя сделать заказ. " + queue.get(0).getName() + " еще не забрал свой!");
                break;
            default:
                System.out.println("очередь пуста");
                break;
        }
    }

    @Override
    public void takeInQueue(Actor actor) {
        queue.add(actor);
        update(ENTER_QUEUE);
    }

    @Override
    public void takeOrders() {
        if (!queue.get(0).isMakeOrder && !queue.get(0).isTakeOrder) {
            queue.get(0).setMakeOrder(true);
            update(MAKE_ORDER);
        } else {
            update(ERROR_TAKE);
        }
    }

    @Override
    public void giveOrders() {
        if (queue.size() > 0) {
            if (queue.get(0).isMakeOrder) {
                queue.get(0).setTakeOrder(true);
                update(TAKE_ORDER);
            } else {
                update(NO_ORDER);
            }
            return;
        }
        update(ZERO_QUEUE);
    }

    @Override
    public void releaseFromQueue() {
        if (queue.size() > 0) {
            if (queue.get(0).isTakeOrder) {
                update(LEAVE_QUEUE);
                queue.remove(0);
            } else {
                update(NOT_TAKE);
            }
            return;
        }
        update(ZERO_QUEUE);
    }
}
