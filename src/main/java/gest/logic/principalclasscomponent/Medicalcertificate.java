package gest.logic.principalclasscomponent;

import java.time.LocalDate;
import java.awt.image.BufferedImage;

public class Medicalcertificate {
    private LocalDate ExpiryDate;
    private BufferedImage certificateImage;
    public Medicalcertificate(LocalDate expiryDate, BufferedImage certificateImage) {
        ExpiryDate = expiryDate;
        this.certificateImage = certificateImage;
    }
    public LocalDate getExpiryDate() {
        return ExpiryDate;
    }
    public void setExpiryDate(LocalDate expiryDate) {
        ExpiryDate = expiryDate;
    }
    public BufferedImage getCertificateImage() {
        return certificateImage;
    }
    public void setCertificateImage(BufferedImage certificateImage) {
        this.certificateImage = certificateImage;
    }
     //nella classe utils mettere gestione date(non sono sicuro) e gestione immagine(sicuramente);
    
}
