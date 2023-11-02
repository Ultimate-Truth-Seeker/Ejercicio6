public class Telefono implements DispositivoElectronico {
    /**
     *modelo del teléfono
     */
    private String modelo;
    /**
     * estado del teléfono
     */
    private boolean turnedOn;
    /**
     * constructor de la clase
     * @param turnedOn
     * @param modelo
     */
    public Telefono(boolean turnedOn, String modelo) {
        this.turnedOn = turnedOn;
        this.modelo = modelo;
    }
    /**
     * getter de modelo
     * @return modelo del teléfono
     */
    public String getModelo() {
        return modelo;
    }
    // métodos previamente comentados
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
