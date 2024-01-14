package com.example.demo.utils;

import com.example.demo.roles.Role;
import com.example.demo.roles.RoleType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SecurityWrapper {
    public static HashMap <String, List<RoleType>> securityDict = new HashMap<>();

    static {
        List<RoleType> viewbooksRoles = Arrays.asList(RoleType.ADMIN, RoleType.USER, RoleType.LIBRARIAN);
        List<RoleType> allRoles = Arrays.asList(RoleType.MODERATOR, RoleType.ADMIN, RoleType.USER, RoleType.LIBRARIAN);
        List<RoleType> viewrequestsRoles = Arrays.asList(RoleType.MODERATOR, RoleType.USER, RoleType.LIBRARIAN);
        List<RoleType> viewusersRoles = Arrays.asList(RoleType.MODERATOR, RoleType.ADMIN, RoleType.LIBRARIAN);
        List<RoleType> librarianRoles = List.of(RoleType.LIBRARIAN);
        securityDict.put(ConfigurationManager.getProperty("command.name.viewbooks"), viewbooksRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.viewrequests"), viewrequestsRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.viewcommonusers"), librarianRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttomainmenu"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.viewusers"), viewusersRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.VIEWISSUANCES"), librarianRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.viewissuanceinfo"), librarianRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttoaddbookpage"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttouserpage"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttocatalog"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttoeditbook"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttoissuances"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttousercatalog"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttouseredit"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.addbooks"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.adduser"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.blockunblock"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.bookrequestadd"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.bookrequestdelete"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.deletebook"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.editbook"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.editissuancedates"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.edituser"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.ratebook"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.updaterequestsstatus"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.userdelete"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.viewuserinformation"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.viewissuanceinformation"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.viewuserrequests"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.viewusersrequestsinformation"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.viewbookinformation"), allRoles);



    }

    public static boolean checkRoleForCommand(String commandAddress, RoleType roleToCheck) {
        if (securityDict.containsKey(commandAddress)) {
            List<RoleType>  roles = securityDict.get(commandAddress);
            return roles.contains(roleToCheck);
        }
        return false;
    }
}