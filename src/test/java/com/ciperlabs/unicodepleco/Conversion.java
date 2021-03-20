package com.ciperlabs.unicodepleco;

import com.ciperlabs.unicodepleco.documentHandler.PDF.PDFToUnicodePDFBOX;
import com.ciperlabs.unicodepleco.documentHandler.PDF.PDFToUnicodeiText;
import com.ciperlabs.unicodepleco.documentHandler.word.HWPFtoXWPF;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Conversion {

    // Property will not autowire when running the main function, so set the variable
    @Value("${storage.Document.root}")
    private static String rootDocumentDirectory = "/home/education/Repositories/PLECO_WORK_DIR/";

    public static void main(String[] args) {
//        testDocFileConversion();
        testPDFBoxUnicodeDocumentConversion();
//        testITextUnicodeDocumentConversion()
    }

    private static void testDocFileConversion(){
        File file = new File(rootDocumentDirectory+"unicode-pleco/test Samples/doc/test.doc");
        FileInputStream input = null;
        try {
            input = new FileInputStream(file);
            try {
                MultipartFile multipartFile = new MockMultipartFile("file",
                        file.getName(), "application/msword", IOUtils.toByteArray(input));
//                HWPFtoXWPF hwpFtoXWPF = new HWPFtoXWPF(multipartFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void testPDFBoxUnicodeDocumentConversion() {
        FileInputStream input = null;
            try {
                PDFToUnicodePDFBOX pdfToUnicode = new PDFToUnicodePDFBOX();
                File file = new File(rootDocumentDirectory + "unicode-pleco/test Samples/PDF/2.pdf");
                String outputPath = rootDocumentDirectory+"output/filename.txt";
                pdfToUnicode.startConversion(file,outputPath);

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    private static void testITextUnicodeDocumentConversion() {
        FileInputStream input = null;
        try {
            PDFToUnicodeiText pdfToUnicode = new PDFToUnicodeiText();
            File file = new File(rootDocumentDirectory + "unicode-pleco/test Samples/PDF/2.pdf");
            String outputPath = rootDocumentDirectory+"output/pdf3.docx";
            pdfToUnicode.startConversion(file,outputPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
