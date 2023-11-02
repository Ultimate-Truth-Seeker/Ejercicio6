public interface DispositivoElectronico {
    /**
     * método para encender el dispositivo
     */
    public void On();
    /**
     * método para apagar el dispositivo
     */
    public void Off();
    
    /**
     * verifica el estado del dispositivo
     * @return true si está encendido, false si está apagado
     */
    public boolean isTurnedOn();
    
}
