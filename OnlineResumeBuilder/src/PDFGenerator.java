import domain.Header;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;

public class PDFGenerator {

    public static void generatePDF(Header header) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                float margin = 20; // Adjust the margin
                float yStart = page.getMediaBox().getHeight() - margin; // Start from the top of the page with a small top margin

                // Load custom font
                final String FONT_PATH = "C:\\Windows\\Fonts\\BOOKOSBI.TTF";  // Replace with the actual font file path
                PDType0Font font = PDType0Font.load(document, new File(FONT_PATH));
                contentStream.setFont(font, 12); // Set the default font
                contentStream.beginText();

                // Adjust the width and positioning of the text box
                float textWidth = font.getStringWidth(header.getFullName()) / 1000 * 12;
                float textX = 10;

                contentStream.newLineAtOffset(textX, yStart - margin); // Adjusted yStart

                setLeading(contentStream, 14); // Set the leading for line spacing

                addText(contentStream, header.getFullName(), font, 24);
                addText(contentStream, header.getDesignation(), font, 12);

                addText(contentStream, header.getEmailId(), font, 12);

                addText(contentStream, header.getContactNumber(), font, 12);

                addText(contentStream, header.getAddress(), font, 12);
                addText(contentStream, header.getDOB(), font, 12);

                contentStream.endText(); // Add this line to end the text block

                // Draw a line
                float lineWidth = 1.5f; // Set the line width
                float lineY = 670 ; // Adjust the position based on your text sizes
                contentStream.setLineWidth(lineWidth);
                contentStream.moveTo(margin, lineY);
                contentStream.lineTo(page.getMediaBox().getWidth() - margin, lineY);
                contentStream.stroke();

                // About Me section in bold
//                contentStream.setFont(boldFont, 14); // Set the bold font and adjust the font size
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, lineY - 10); // Adjust the Y position based on the line position
                contentStream.showText("About Me");
                contentStream.endText();


            }

            document.save("output.pdf");
            document.close();
            System.out.println("PDF generated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setLeading(PDPageContentStream contentStream, float leading) throws IOException {
        contentStream.setLeading(leading);
    }

    private static void addText(PDPageContentStream contentStream, String text, PDType0Font font, float fontSize) throws IOException {
        String[] lines = text.split("\n");
        for (String line : lines) {
            contentStream.setFont(font, fontSize);
            contentStream.showText(line);
            contentStream.newLine();
        }
    }
}
