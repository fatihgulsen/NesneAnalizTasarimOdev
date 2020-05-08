package nytOdevPac;
import java.util.ArrayList;
import java.util.Random;


public class SicaklikSensoru implements Subject {

    private static SicaklikSensoru instance;
    private ArrayList observers;
    private boolean durum;
    private int sicaklik;

    private SicaklikSensoru()
    {
        Random rd = new Random();
        observers =  new ArrayList();
        durum=true;
        sicaklik=rd.nextInt(30);
    }

    public static synchronized SicaklikSensoru getInstance(){
        if (instance==null)
            instance =  new SicaklikSensoru();
        return instance;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(sicaklik,durum);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements() {
        Random rd = new Random();
        this.sicaklik = rd.nextInt(30);
        measurementsChanged();
    }

    public int getSicaklik(){
        return sicaklik;
    }

    public boolean getDurum(){
        return durum;
    }

    public void setDurum(boolean durum){
        this.durum=durum;
        measurementsChanged();
    }

}
