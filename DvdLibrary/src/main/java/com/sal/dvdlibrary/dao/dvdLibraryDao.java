/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sal.dvdlibrary.dao;

import com.sal.dvdlibrary.dto.DvD;
import java.util.List;

public interface dvdLibraryDao {
     /**
     * Adds the given Dvd to the library and associates it with the given
     * Title. If there is already a dvd associated with the given
     * title it will return that dvd object, otherwise it will
     * return null.
     *
     * @param title with which dvd is to be associated
     * @param dvd dvd to be added to the library
     * @return the dvd object previously associated with the given  
     * title if it exists, null otherwise
     */
    DvD addDvd(String title, DvD dvd) throws DvdLibraryDaoException;

    /**
     * Returns a List of all dvds in the library.
     *
     * @return List containing all dvds in the library.
     */
    List<DvD> getAllDvds() throws DvdLibraryDaoException;

    /**
     * Returns the dvd object associated with the given title.
     * Returns null if no such dvd exists
     *
     * @param title title of the dvd to retrieve
     * @return the dvd object associated with the given title,  
     * null if no such dvd exists
     */
    DvD getDvd(String title) throws DvdLibraryDaoException;

    /**
     * Removes from the library the dvd associated with the title.
     * Returns the dvd object that is being removed or null if
     * there is no dvd associated with the title
     *
     * @param title title of dvd to be removed
     * @return dvd object that was removed or null if no dvd
     * was associated with the given title
     */
    DvD removeDvd(String title) throws DvdLibraryDaoException;
    /**
     * Edits the dvd associated with the title.
     * Returns the dvd object that is being edited or null if
     * there is no dvd associated with the title
     *
     * @param title title of dvd to be edited
     * @return dvd object that was edited or null if no dvd
     * was associated with the given title
     */
    DvD editReleaseDate(String title, String newReleaseDate) throws DvdLibraryDaoException;

    DvD editMPAA(String title, String newMpaaRating) throws DvdLibraryDaoException;

    DvD editDirectorName(String title, String newDirectorName) throws DvdLibraryDaoException;

    DvD editUserRating(String title, String newUserRating) throws DvdLibraryDaoException;

    DvD editStudio(String title, String newStudioName) throws DvdLibraryDaoException;
}
