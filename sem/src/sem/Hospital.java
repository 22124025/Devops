package sem;

public class Hospital {
    private int id;
    private String name;
    private String phone;
    private String address;
    private int room; // Assuming this is for the number of rooms available

    public Hospital(int id, String name, String phone, String address, int room) {
        this.setId(id);
        this.setName(name);
        this.setPhone(phone);
        this.setAddress(address);
        this.setRoom(room);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
