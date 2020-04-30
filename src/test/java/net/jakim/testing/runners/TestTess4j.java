package net.jakim.testing.runners;

import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.Word;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.vladsch.flexmark.util.ImageUtils.toBufferedImage;

public class TestTess4j
{
    public static void main( String[] args )
        throws
        TesseractException,
        IOException
    {
        File imageFile = new File( "screenshot.png" );
        Image image = ImageIO.read( imageFile );
        BufferedImage bi = toBufferedImage( image );
        Tesseract tesseract = new Tesseract( );
        tesseract.setDatapath( "src/test/resources/tessdata" );
        tesseract.setLanguage( "eng" );
        tesseract.setPageSegMode( 1 );
        tesseract.setOcrEngineMode( 1 );
        String result = tesseract.doOCR( imageFile );
        System.out.println( result );

        for ( Word word : tesseract.getWords( bi,
                                              ITessAPI.TessPageIteratorLevel.RIL_TEXTLINE ) )
        {
            Rectangle rect = word.getBoundingBox( );

            System.out.println( rect.getMinX( ) + "," + rect.getMaxX( ) + "," + rect.getMinY( ) + "," + rect.getMaxY( ) + ": " + word.getText( ) );
        }
    }
}
