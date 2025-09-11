package com.example.Gestion_Tourisme.utils;

import com.example.Gestion_Tourisme.entity.Paiement;
import com.example.Gestion_Tourisme.entity.Reservation;
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class PdfGenerator {

    /*public static ByteArrayInputStream generateFacture(Reservation reservation, Paiement paiement) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Titre
            Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
            Paragraph title = new Paragraph("Facture de Paiement", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Réservation ID: " + reservation.getId()));
            document.add(new Paragraph("Client: " + reservation.getClient().getName()));
            document.add(new Paragraph("Service: " + reservation.getService().getNom()));
            document.add(new Paragraph("Montant payé: " + paiement.getMontant() + " FCFA"));
            document.add(new Paragraph("Date du paiement: " + paiement.getDatePaiement()));
            document.add(new Paragraph("Statut: " + paiement.getStatut()));

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }/

        return new ByteArrayInputStream(out.toByteArray());
    }*/
}
