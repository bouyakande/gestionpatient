package serviceControl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContolleCode {

    public static int controlDate() {
        return 0;
    }

    public static int controlInt( String val) {
        int bon = 0;
        try {
            int b = Integer.parseInt(val);
            bon=1;
        } catch (Exception e) {
            bon = 0;
        }
        return bon;
    }

    public static int controlString( String chaine) {
        int nombre = 0;
        int trve = 0;
       
        Pattern pattern = Pattern.compile("[^A-Z&&[^a-z&&[^0-9&&[^ ]]]]");
        Matcher matcher = pattern.matcher(chaine);

        while (matcher.find()) {
            nombre++;
        }
        if (nombre > 0) {
            System.out.println("\nIl y a " + nombre + " lettre(s) (ou caractere(s)) non conforme(s) !!!");  // bien entendu redemander une saisie correcte...
                 trve = 1;
        } else {
            System.out.println("\nIl n'y a pas de lettre(s) (ou caractere(s)) non conforme(s) !!!");
            trve = 0;
        }
        return trve;
    }

    public static int controlTel() {
        return 0;
    }
}
