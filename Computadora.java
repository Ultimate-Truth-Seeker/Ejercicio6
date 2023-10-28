public class Computadora implements DispositivoElectronico {
    private String marca;
    private boolean turnedOn;
    public Computadora(boolean turnedOn, String marca) {
        this.turnedOn = turnedOn;
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public void Off() {
        this.turnedOn = false;
    }

    @Override
    public void On() {
        this.turnedOn = true;
        
    }

    @Override
    public boolean isTurnedOn() {
        return turnedOn;
    }
    
}
