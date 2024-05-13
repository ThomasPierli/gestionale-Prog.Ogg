package gest.logic.principalclasscomponent;

import java.time.LocalDate;
import java.awt.image.BufferedImage;

public class Medicalcertificate {
    private LocalDate ExpiryDate;
    private BufferedImage Certificate;

    
    public Medicalcertificate(LocalDate expiryDate, BufferedImage certificate) {
        ExpiryDate = expiryDate;
        Certificate = certificate;
    }
    public LocalDate getExpiryDate() {
        return ExpiryDate;
    }
    public void setExpiryDate(LocalDate expiryDate) {
        ExpiryDate = expiryDate;
    }
    public BufferedImage getCertificate() {
        return Certificate;
    }
    public void setCertificate(BufferedImage certificate) {
        Certificate = certificate;
    }

    //nella classe utils mettere gestione date(non sono sicuro) e gestione immagine(sicuramente);
     
    
    
}
