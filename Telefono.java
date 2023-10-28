public class Telefono implements DispositivoElectronico {
    private String modelo;
    private boolean turnedOn;

    public Telefono(boolean turnedOn, String modelo) {
        this.turnedOn = turnedOn;
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
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
