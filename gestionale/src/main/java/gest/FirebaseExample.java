package gest;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseExample {
    public static void main(String[] args) {
        try {
            // Percorso del file JSON delle credenziali di Firebase
            String pathToCredentials = "path/to/your/firebase-credentials.json";
            
            // Inizializzazione delle credenziali Firebase
            FileInputStream serviceAccount = new FileInputStream(pathToCredentials);
            @SuppressWarnings("deprecation")
            FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://your-firebase-database-url.firebaseio.com")
                .build();
            FirebaseApp.initializeApp(options);
            
            // Ottieni un riferimento al nodo del database Firebase
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("testNode");
            
            // Scrivi dati nel database Firebase
            ref.setValueAsync("Hello, Firebase!");

            System.out.println("Dati scritti correttamente su Firebase.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
