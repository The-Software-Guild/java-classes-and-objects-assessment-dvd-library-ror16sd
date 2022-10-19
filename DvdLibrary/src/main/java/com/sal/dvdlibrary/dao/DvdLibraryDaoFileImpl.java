/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sal.dvdlibrary.dao;

import com.sal.dvdlibrary.dto.DvD;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class DvdLibraryDaoFileImpl implements dvdLibraryDao {

    public final String DVD_FILE;
    public static final String DELIMITER = "::";
    /*
    Hash Map to store and retrieve the dvd with title name
     */
    private Map<String, DvD> dvds = new HashMap<>();

      public DvdLibraryDaoFileImpl(){ //no arg constructor typically used
          DVD_FILE = "dvdTest.txt";
    }
      public DvdLibraryDaoFileImpl(String libraryTextFile){
       DVD_FILE = libraryTextFile;
    }
    
    @Override
    public DvD addDvd(String title, DvD dvd) throws DvdLibraryDaoException
    {
       loadDvdFile();
       DvD prevDvD = dvds.put(title, dvd);
       writeDvdFile();
       return prevDvD;
    }

    /*
    This code gets all of the DvDs objects out of the dvds map as a collection by calling the values() method.
     */
    @Override
    public List<DvD> getAllDvds() throws DvdLibraryDaoException {
        loadDvdFile();
        return new ArrayList<DvD>(dvds.values());
    }

    /*
    This method is quite simple — we just ask the dvds map for the dvd object with the given title and return it
     */
    @Override
    public DvD getDvd(String title)throws DvdLibraryDaoException {
      loadDvdFile();
      return dvds.get(title);
    }

    @Override
    public DvD removeDvd(String title) throws DvdLibraryDaoException{
        loadDvdFile();
        DvD removedDvD = dvds.remove(title);
        writeDvdFile();
        return removedDvD;
    }

    

    /*
    Method to unmarshall the object or read a line of string
    from the line and convert it into an object
     */
    private DvD unmarshallDvd(String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String title = dvdTokens[0];

        DvD dvdFromFile = new DvD(title);
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        dvdFromFile.setMPAA(dvdTokens[2]);
        dvdFromFile.setDirectorsName(dvdTokens[3]);
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setUserRating(dvdTokens[5]);

        return dvdFromFile;
    }

    /*
    Method to Load file DVD_FILE into memory
     */
     private void loadDvdFile() throws DvdLibraryDaoException {
        Scanner scanner;
        try{
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e){
            throw new DvdLibraryDaoException("Could not load dvd library data into memory", e);
        }
        String currentLine;
        DvD currentDvD;
        //go line by line through DVD_FILE to decode into DvD objects
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentDvD = unmarshallDvd(currentLine);

            //put dvd obj into the map with title as key
            dvds.put(currentDvD.getTitle(), currentDvD);
        }
        scanner.close();
    }

    private String marshallDvd(DvD aDvd) {
       //Concat all aDvd information as a String, into formatted file style
        //for saving to DVD_FILE
       String dvdAsText = aDvd.getTitle() + DELIMITER;
       dvdAsText += aDvd.getReleaseDate() + DELIMITER;
       dvdAsText += aDvd.getMPAA() + DELIMITER;
       dvdAsText += aDvd.getDirectorsName() + DELIMITER;
       dvdAsText += aDvd.getStudio() + DELIMITER;
       dvdAsText += aDvd.getUserRating();

       return dvdAsText;
    }

    /**
     * Writes all Dvds in the library out to a DVD_FILE. See loadDvdFile
     * for file format.
     *
     */
    private void writeDvdFile() throws DvdLibraryDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch(IOException e){
            throw new DvdLibraryDaoException("Could not save dvd data.", e);
        }

        // Write out the DvD objects to the DVD file.
        // NOTE TO THE APPRENTICES: We could just grab the dvd map,
        // get the Collection of dvd and iterate over them but we've
        // already created a method that gets a List of dvds so
        // we'll reuse it.
        String dvdAsText;
        List<DvD> dvdList = this.getAllDvds();
        for(DvD currentDvD : dvdList){
            //turn a DvD into a String
            dvdAsText = marshallDvd(currentDvD);
            //write the DvD obj to the file
            out.println(dvdAsText);
            //force PrintWriter to write line to the file
            out.flush();
        }
        out.close();
    }

    @Override
    public DvD editReleaseDate(String title, String newReleaseDate) throws DvdLibraryDaoException {
       loadDvdFile();
        DvD currentDVD = dvds.get(title);
        currentDVD.setReleaseDate(newReleaseDate);
        writeDvdFile();
        return currentDVD;
    }

    @Override
    public DvD editMPAA(String title, String newMpaaRating) throws DvdLibraryDaoException {
        loadDvdFile();
        DvD currentDVD = dvds.get(title);
        currentDVD.setMPAA(newMpaaRating);
        writeDvdFile();
        return currentDVD; 
    }

    @Override
    public DvD editDirectorName(String title, String newDirectorName) throws DvdLibraryDaoException {
        loadDvdFile();
        DvD currentDVD = dvds.get(title);
        currentDVD.setDirectorsName(newDirectorName);
        writeDvdFile();
        return currentDVD; 
    }

    @Override
    public DvD editUserRating(String title, String newUserRating) throws DvdLibraryDaoException {
       loadDvdFile();
        DvD currentDVD = dvds.get(title);
        currentDVD.setUserRating(newUserRating);
        writeDvdFile();
        return currentDVD;  
    }

    @Override
    public DvD editStudio(String title, String newStudioName) throws DvdLibraryDaoException {
        loadDvdFile();
        DvD currentDVD = dvds.get(title);
        currentDVD.setStudio(newStudioName);
        writeDvdFile();
        return currentDVD;    
    }

}
