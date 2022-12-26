package delivery;

public class DeliveryAddressExeption extends Exception {
    @Override
    public String toString() {
        return "\nUser address is incorrect and it can't be used as delivery address. \n";
    }
}
