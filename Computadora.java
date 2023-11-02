public class Computadora implements DispositivoElectronico {
    /**
     * marca de la computadora
     */
    private String marca;
    /**
     * estado de la computadora
     */
    private boolean turnedOn;
    /**
     * constructor de la clase
     * @param turnedOn
     * @param marca
     */
    public Computadora(boolean turnedOn, String marca) {
        this.turnedOn = turnedOn;
        this.marca = marca;
    }
    /**
     * getter de marca
     * @return marca de la computadora
     */
    public String getMarca() {
        return marca;
    }
    // Métodos previamente comentados
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
