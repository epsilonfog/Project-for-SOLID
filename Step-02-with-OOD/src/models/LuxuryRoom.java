public class LuxuryRoom extends Room {
    public LuxuryRoom(String number, double price){
        super(number, "luxury", price);
        addService(new FreeDinnerService());
    }
}
