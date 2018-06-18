package com.esipovich.challenge.path;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Artem Esipovich 18.06.2018
 *
 * Write a function that provides change directory (cd) function for an abstract file system.
 *
 * Notes:
 *
 *  Root path is '/'.
 *  Path separator is '/'.
 *  Parent directory is addressable as "..".
 *  Directory names consist only of English alphabet letters (A-Z and a-z).
 *  The function should support both relative and absolute paths.
 *  The function will not be passed any invalid paths.
 *  Do not use built-in path-related functions.
 *
 * For example:
 *  Path path = new Path("/a/b/c/d");
 *  path.cd('../x');
 *  System.out.println(path.getPath());
 *
 * should display '/a/b/c/x'.
 */

public class Path {

    private String path;
    private LinkedList<String> folderTree = new LinkedList<>();

    public Path(String path) {
        this.path = path;
        Collections.addAll(folderTree, this.path.split("/"));
        folderTree.removeFirst();
    }

    public String getPath() {
        return path;
    }

    public void cd(String newPath) {
        if (newPath.startsWith("/")){
            path = newPath;
            return;
        }
        String[] commands = newPath.split("/");
        for (String command : commands) {
            if ("..".equals(command)) {
                folderTree.removeLast();
            } else {
                folderTree.addLast(command);
            }
        }
        StringBuilder newPathToReturn = new StringBuilder();
        for (String folder : folderTree){
            newPathToReturn.append("/").append(folder);
        }
        path = newPathToReturn.toString();
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("/b/d");
        System.out.println(path.getPath());
    }

}
