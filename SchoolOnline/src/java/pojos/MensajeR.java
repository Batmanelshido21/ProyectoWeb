/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author javie
 */
public class MensajeR {
    
    private boolean error;

    public MensajeR() {
    }

    public MensajeR(boolean error) {
        this.error = error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean isError() {
        return error;
    }
     
    
}
