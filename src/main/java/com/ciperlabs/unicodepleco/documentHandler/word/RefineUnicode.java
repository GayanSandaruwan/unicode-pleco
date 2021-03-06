package com.ciperlabs.unicodepleco.documentHandler.word;


import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.List;

/**
 * Created by gayan@ciperlabs.com on 4/19/18.
 */
public class RefineUnicode {


    public static void main(String[] args) {
        File file = new File("test.docx");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XWPFDocument doc = null;
        try {
            doc = new XWPFDocument(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (XWPFParagraph p : doc.getParagraphs()) {
//            System.out.println("*********************************************");
            List<XWPFRun> runs = p.getRuns();
            for (XWPFRun run : runs) {

                String nextText = run.getText(0);
                if (nextText == null) {
                    nextText = "";
                }
                nextText = nextText.replaceAll("÷ු", "ද");
//                        if(nextText!=null && nextText.equals("ිුී")){
//                            nextRun.setText("ඳි");
//                        }
                nextText = nextText.replaceAll("ිුී", "ඳි");
                run.setText(nextText, 0);

//                    if(i+1 < runsLength){
//                        XWPFRun nextRun = runs.get(i+1);
//                        String nextText = nextRun.getText(0);
//                        String[] nonStartables = { "ා","ැ","ෑ","ි","ී","ු" ,"ූ","ෘ","ෙ",
//                                "ේ","ෛ","ො","ෝ","ෞ","ෟ","ෲ","ෳ","්"};
//                        for (String nonStartable: nonStartables ) {
//                            if(nextText!= null && nextText.startsWith(nonStartable)){
//                                run.setText(nonStartable,-1);
//                                nextText  = nextText.substring(1);
//                                nextRun.setText(nextText,0);
//                            }
//                        }


//                    }

            }

//                for (XWPFRun r : runs) {
//                    String text = r.getText(0);
//                    String font_family = r.getFontFamily();
//                    System.out.println(text + "  : " + font_family);
//                }
        }
        try {
            doc.write(new FileOutputStream("output.docx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

