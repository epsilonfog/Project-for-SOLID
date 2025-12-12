public class Room {

    protected String number;
    protected String type;
    protected double price;

    private List<RoomService> services = new ArrayList<>();

    public Room(String number, String type, double price){
        this.number = number;
        this.type = type;
        this.price = price;
    }

    public void addService(RoomService service){
        services.add(service);
        service.apply(this);
    }

    public String getNumber(){
        return number;
    }
}
