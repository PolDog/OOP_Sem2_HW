public interface QueueBehaviour {
    void takeInQueue(Actor actor);

    void takeOrders(); //сделать заказ

    void giveOrders(); // забрать заказ

    void releaseFromQueue(); // выйти из очереди


}
