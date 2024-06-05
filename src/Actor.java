public abstract class Actor implements ActorBehavoir {
    protected String name;
    protected boolean isMakeOrder;
    protected boolean isTakeOrder;

    public Actor(String name) {
        this.name = name;
        isTakeOrder = false;
        isMakeOrder = false;
    }

    public abstract String getName();


}
