package epsi.mspr.maintenance.based.worker;

import epsi.mspr.maintenance.based.models.Document;
import epsi.mspr.maintenance.based.models.Res;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWorker {
    public static void writeToCsv(String filePath, Document document) throws IOException {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(filePath), CSVFormat.DEFAULT
                .withHeader("UniqueId", "CodeInstitution", "Jour", "Horaire", "Ouvert"))) {

            Res response = document != null ? document.getResponse() : null;
            if (response != null && document.getRequest() != null && document.getRequest().getInstitution() != null &&
                    document.getRequest().getPlage() != null) {

                printer.printRecord(
                        response.getUniqueId(),
                        document.getRequest().getInstitution().getCode(),
                        document.getRequest().getPlage().getJour(),
                        document.getRequest().getPlage().getHoraire(),
                        String.valueOf(response.isOuvert())
                );

            } else {
                System.out.println("Les données nécessaires ne sont pas présentes dans le document XML.");
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du CSV : " + e.getMessage());
            throw e; // Réexécutez l'exception après l'avoir gérée localement
        }
    }
}

