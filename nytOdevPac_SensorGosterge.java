package nytOdevPac;

public class SensorGosterge implements Observer,DisplayElement {
    private int sicaklik;
    private boolean durum;
    private SicaklikSensoru sensor;

    public SensorGosterge(SicaklikSensoru sensor)
    {
        this.sensor=sensor;
        sensor.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Sicaklik : ");
        System.out.print(sicaklik);
        System.out.println("\nSensor Durumu : ");
        if (durum==true)
            System.out.print("Acik");
        else
            System.out.print("Kapali");

    }

    @Override
    public void update(int sicaklik,boolean durum) {
        this.sicaklik=sicaklik;
        this.durum = durum;
        display();
    }
}
