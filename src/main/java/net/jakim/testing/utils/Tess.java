package net.jakim.testing.utils;

import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.Word;
import org.openqa.selenium.Point;

import java.awt.*;
import java.awt.image.BufferedImage;

public enum Tess
{
    EN_OCR( "eng" );

    private final String language;
    private final String tessdata = "src/test/resources/tessdata";
    private final Tesseract tesseract;

    Tess( String language )
    {
        this.language = language;
        this.tesseract = new Tesseract( );
        this.tesseract.setDatapath( tessdata );
        this.tesseract.setLanguage( language );
        this.tesseract.setPageSegMode( 1 );
        this.tesseract.setOcrEngineMode( 1 );
    }

    public String extractTextFrom( final BufferedImage bufferedImage )
    {
        try
        {
            return this.tesseract.doOCR( bufferedImage );
        }
        catch ( TesseractException e )
        {
            e.printStackTrace( );
            throw new RuntimeException( "Problem while extracting text from buffered image" );
        }
    }

    public Point getTextCenterCoordsFromImage( final String text,
                                               final BufferedImage bufferedImage )
    {
        Point point = null;
        for ( Word word : tesseract.getWords( bufferedImage,
                                              ITessAPI.TessPageIteratorLevel.RIL_WORD ) )
        {
            Rectangle rect = word.getBoundingBox( );
            String wordText = word
                .getText( )
                .trim( );

            System.out.println( rect.getMinX( ) + "," + rect.getMaxX( ) + "," + rect.getMinY( ) + "," + rect.getMaxY( ) + ": " + wordText );

            if ( wordText.equalsIgnoreCase( text ) )
            {

                int x = getCenterOf( rect.getMinX( ),
                                     rect.getMaxX( ) );

                int y = getCenterOf( rect.getMinY( ),
                                     rect.getMaxY( ) );
                point = new Point( x,
                                   y );
                break;
            }
        }

        System.out.println( "Got clicking coordinates" + point );
        return point;
    }

    private int getCenterOf( final double minPos,
                             final double maxPos )
    {
        double distance = maxPos - minPos;
        return ( int ) ( minPos + ( distance / 2 ) );
    }

    public Point getTextStartCoordsFromImage( final String text,
                                              final BufferedImage bufferedImage )
    {
        Point point = null;
        for ( Word word : tesseract.getWords( bufferedImage,
                                              ITessAPI.TessPageIteratorLevel.RIL_TEXTLINE ) )
        {
            Rectangle rect = word.getBoundingBox( );
            String wordText = word
                .getText( )
                .trim( );

            System.out.println( rect.getMinX( ) + "," + rect.getMaxX( ) + "," + rect.getMinY( ) + "," + rect.getMaxY( ) + ": " + wordText );

            if ( wordText.equalsIgnoreCase( text ) )
            {

                int x = ( int ) rect.getMinX( ) - 10;

                int y = getCenterOf( rect.getMinY( ),
                                     rect.getMaxY( ) );
                point = new Point( x,
                                   y );
            }
        }

        System.out.println( "Got clicking coordinates" + point );
        return point;
    }
}
