package epsi.mspr.maintenance.based.controller;

import epsi.mspr.maintenance.based.models.Document;
import epsi.mspr.maintenance.based.worker.CsvWorker;
import epsi.mspr.maintenance.based.worker.XmlWorker;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/horaires")
public class CsvController {
    @GetMapping("/{codeInstitution}/{date}")
    public ResponseEntity<byte[]> generateCsv(@PathVariable String codeInstitution, @PathVariable String date) throws JAXBException, IOException {
        String xmlFilePath = "D:/PMN/source/BASED 1/BASED - Copie/PORTE/exampleRequest.xml";

        Document document = XmlWorker.readFromXml(xmlFilePath);
        String csvFileName = codeInstitution + "_" + date + ".csv";

        // Chemin où vous souhaitez enregistrer le fichier CSV

        String csvFilePath = "C:/Users/eya thebti/Downloads" + csvFileName;

        // Génération du fichier CSV
        CsvWorker.writeToCsv(csvFilePath, document);

        // Lecture du fichier CSV en tant que tableau d'octets
        byte[] csvBytes = Files.readAllBytes(Paths.get(csvFilePath));

        // Création de l'en-tête de la réponse pour indiquer le type de contenu
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("text/csv"));
        headers.setContentDispositionFormData(csvFileName, csvFileName);

        // Renvoi du fichier CSV en tant que réponse HTTP
        return new ResponseEntity<>(csvBytes, headers, HttpStatus.OK);
    }
}
