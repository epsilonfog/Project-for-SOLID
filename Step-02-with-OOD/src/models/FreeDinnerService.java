public class FreeDinnerService implements RoomService {
    @Override
    public void apply(Room room) {
        System.out.println("Free dinner added for room " + room.getNumber());
    }
}
