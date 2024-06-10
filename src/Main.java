import java.util.ArrayList;import java.util.List;public class Main
{
    public static void main(String[] args)
    {
        User user1 = new User("Пользователь 1");
        User user2 = new User("Пользователь 2");
        CentralComp centralComp1 = new CentralComp("Группа 1");
        CentralComp centralComp2 = new CentralComp("Группа 2");
        CentralComp centralComp3 = new CentralComp("Группа 3");
        CentralComp centralComp4 = new CentralComp("Группа 4");
        centralComp1.addObserver(user1);
        centralComp1.addObserver(user2);
        centralComp2.addObserver(user1);
        centralComp2.addObserver(user2);
        centralComp3.addObserver(user1);
        centralComp4.addObserver(user1);
        centralComp3.addObserver(user2);
        centralComp1.notifyObserver("уведомление от группы 1");
        centralComp2.notifyObserver("уведомление от группы 2");
        centralComp3.notifyObserver("уведомление от группы 3");
        centralComp4.notifyObserver("уведомление от группы 4");
    }

}
interface Notifier
{
    public void addObserver(Observer obs);
    public void removeObserver (Observer obs);
    public void notifyObserver (String notification);
}
interface Observer{
    public void update(String notification);}
class User implements Observer
{
    String Name;
    public User(String Name)
    {
        this.Name = Name;
    }

    @Override    public void update(String notification)
    {
        System.out.println( Name + " Вам пришло " + notification);
    }
}
class CentralComp implements Notifier
{
    private List observers;
    private String name;
    public CentralComp(String name)
    {
        this.name = name;
        observers = new ArrayList();
    }
    public void addObserver(Observer obs){
        observers.add(obs);
    }
    public void removeObserver (Observer obs)
    {
        int i = observers.indexOf(obs);
        if ( i >= 0)
        {
            observers.remove(i);
        }
    }
    public void notifyObserver (String notification)
    {
        for ( int i = 0; i < observers.size(); i++)
        {
            Observer obs = (Observer)observers.get(i);
            obs.update(notification);
        }
    }
}