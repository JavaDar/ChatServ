package ua.dp.daragan;

public interface ClientsListner {
    public void addClient(Clients cl);
    public void delClient(Clients cl);
    public void addMsg(String s);
    public void sendToAll();
}
