/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sal.dvdlibrary.ui;

import com.sal.dvdlibrary.dto.DvD;
import java.util.List;


public class DvdLibraryView {

    private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
       io.print("Main Menu");
       io.print("1. List All DvDs in the Library");
       io.print("2. Add DvD to the Library");
       io.print("3. Remove DvD from the Library");
       io.print("4. Edit a DvD in the Library");
       io.print("5. View DvD in the Library");
       io.print("6. Exit");

       return io.readInt("Please select from the menu", 1,6);
    }

    public int printEditMenuAndGetSelection() {
      io.print("Edit Menu");
      io.print("1. Edit Release Date");
      io.print("2. Edit MPAA");
      io.print("3. Edit Director Name");
      io.print("4. Edit User Rating");
      io.print("5. Edit Studio Name");
      io.print("6. Exit");

      return io.readInt("Please select from the menu", 1, 6);
    }
    /*
     This method prompts the user for dvd ID, First Name, Last Name, and Cohort, 
    gathers this information, creates a new dvd object, and returns it to the caller.
     */
    public DvD getNewDvDInfo() {
        String Title = io.readString("Please enter DvD Title");
        String ReleaseDate = io.readString("Please enter DvD Release Date");
        String MPAA = io.readString("Please enter DvD MPAA");
        String DirectorsName = io.readString("Please enter DvD Director's Name");
        String Studio = io.readString("Please enter DvD Studio Name");
        String  UserRating= io.readString("Please enter DvD User Rating");

        DvD currentDvD = new DvD(Title);
        currentDvD.setReleaseDate(ReleaseDate);
        currentDvD.setMPAA(MPAA);
        currentDvD.setDirectorsName(DirectorsName);
        currentDvD.setStudio(Studio);
        currentDvD.setUserRating(UserRating);

        return currentDvD;
    }

    /*
    This method simply displays a banner or heading to the UI indicating that 
    the next interactions on the screen will be for creating a new dvd
     */
    public void displayCreateDvDBanner() {
        io.print("=== Create DvD ===");
    }

    /*
    The second method displays a message that the new dvd was successfully created
    and waits for the user to hit Enter to continue
     */
    public void displayCreateSuccessBanner() {
        io.readString(
                "DvD successfully created.  Please hit enter to continue");
    }

    /*
    A method that takes a list of DVD objects as a parameter and displays the information for each Dvd to the screen.
     */
    public void displayDvdList(List<DvD> dvdList) {
        for(DvD currentDvD : dvdList){
            String dvdInfo = String.format("%s : %s\nStudio: %s\nRelease Date: %s\nMPAA: %s\nRating: %s\n",
                    currentDvD.getTitle(),
                    currentDvD.getDirectorsName(),
                    currentDvD.getReleaseDate(),
                    currentDvD.getStudio(),
                    currentDvD.getMPAA(),
                    currentDvD.getUserRating());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Dvds ===");
    }

    /*
    Shows the DvD banner
     */
    public void displayDisplayDvdBanner() {
        io.print("=== Display Dvd ===");
    }

    /*
    Get the dvd title to display information
     */
    public String getDvdTitleChoice() {
        return io.readString("Please enter the dvd title.");
    }

    /*
    Displays the dvd information
     */
    public void displayDvd(DvD dvd) {
        if(dvd != null){
            String dvdInfo = String.format("%s : %s\nStudio: %s\nRelease Date: %s\nMPAA: %s\nRating: %s\n",
                    dvd.getTitle(),
                    dvd.getDirectorsName(),
                    dvd.getStudio(),
                    dvd.getReleaseDate(),
                    dvd.getMPAA(),
                    dvd.getUserRating());
            io.print(dvdInfo);
        }
        else{
            io.print("No such dvd.");
        }
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove Dvd ===");
    }

    public void displayRemoveResult(DvD dvdRecord) {
       if (dvdRecord != null){
           io.print("DvD successfully removed.");
       }
       else{
           io.print("No such dvd.");
       }
       io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    public void displayEditDvdBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayEditDvdSuccess() {
        io.readString(
                "DVD successfully Edited.  Please hit enter to continue");
    }

    public void displayEditReleaseDateBanner() {
        io.print("=== Edit DVD Release Date ===");
    }

    public void displayEditMpaaBanner() {
        io.print("=== Edit DVD MPAA rating ===");
    }

    public void displayEditDirectorNameBanner() {
        io.print("=== Edit DVD Director's Name ===");
    }

    public void displayEditStudio() {
        io.print("=== Edit DVD Studio ===");
    }

    public void displayEditUserRating() {
        io.print("=== Edit DVD User Rating ===");
    }

    public String getNewReleaseDate() {
        return io.readString("Please enter new release date.");
    }

    public String getNewMpaaRating() {
        return io.readString("Please enter new MPAA rating.");
    }

    public String getNewDirectorName() {
        return io.readString("Please enter new director's name.");
    }

    public String getNewUserRating() {
        return io.readString("Please enter new user rating.");
    }

    public String getNewStudio() {
        return io.readString("Please enter new studio.");
    }

    public void displayNullDVD() {
        io.print("No such DVD.");
        io.readString("Please hit enter to continue.");
    }
}
