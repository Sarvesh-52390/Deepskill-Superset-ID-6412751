package FactoryMethodPatternExample;

public class Main {

    
    interface Document {
        void open();
    }

    static class WordDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening Word Document");
        }
    }

    
    static class PdfDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening PDF Document");
        }
    }

   
    static class ExcelDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening Excel Document");
        }
    }

    
    enum DocumentType {
        WORD, PDF, EXCEL
    }

    
    static class SimpleDocumentFactory {

        public static Document createDocument(DocumentType type) {
            switch (type) {
                case WORD:
                    return new WordDocument();
                case PDF:
                    return new PdfDocument();
                case EXCEL:
                    return new ExcelDocument();
                default:
                    throw new IllegalArgumentException("Unknown document type");
            }
        }
    }

    public static void main(String[] args) {
        Document wordDoc = SimpleDocumentFactory.createDocument(DocumentType.WORD);
        wordDoc.open();

        Document pdfDoc = SimpleDocumentFactory.createDocument(DocumentType.PDF);
        pdfDoc.open();

        Document excelDoc = SimpleDocumentFactory.createDocument(DocumentType.EXCEL);
        excelDoc.open();
    }
}
