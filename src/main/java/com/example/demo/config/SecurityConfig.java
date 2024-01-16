package com.example.demo.config;

import com.example.demo.roles.Role;
import com.example.demo.roles.RoleType;
import com.example.demo.utils.ConfigurationManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SecurityConfig {
    public static HashMap <String, List<RoleType>> securityDict = new HashMap<>();

    static {

        List<RoleType> allRoles = Arrays.asList(RoleType.MODERATOR, RoleType.ADMIN, RoleType.USER, RoleType.LIBRARIAN);
        securityDict.put(ConfigurationManager.getProperty("command.name.viewbooks"), List.of(RoleType.ADMIN, RoleType.LIBRARIAN, RoleType.USER));
        securityDict.put(ConfigurationManager.getProperty("command.name.viewrequests"), List.of(RoleType.ADMIN, RoleType.LIBRARIAN, RoleType.USER));
        securityDict.put(ConfigurationManager.getProperty("command.name.viewcommonusers"), List.of(RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttomainmenu"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.viewusers"), List.of(RoleType.ADMIN, RoleType.LIBRARIAN, RoleType.MODERATOR));
        securityDict.put(ConfigurationManager.getProperty("command.name.VIEWISSUANCES"), List.of(RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.viewissuanceinfo"), List.of(RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttocatalog"), List.of(RoleType.ADMIN, RoleType.LIBRARIAN, RoleType.USER));
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttoeditbook"), List.of(RoleType.ADMIN, RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttoissuances"), List.of(RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttousercatalog"), List.of(RoleType.ADMIN, RoleType.LIBRARIAN, RoleType.MODERATOR));
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttoedituser"), List.of(RoleType.ADMIN));
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttoadduserpage"), List.of(RoleType.ADMIN));
        securityDict.put(ConfigurationManager.getProperty("command.name.addbooks"), List.of(RoleType.ADMIN, RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.adduser"), List.of(RoleType.ADMIN));
        securityDict.put(ConfigurationManager.getProperty("command.name.blockunblock"), List.of(RoleType.MODERATOR));
        securityDict.put(ConfigurationManager.getProperty("command.name.bookrequestadd"), List.of(RoleType.ADMIN, RoleType.USER, RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.bookrequestdelete"), List.of(RoleType.ADMIN, RoleType.USER, RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.deletebook"), List.of(RoleType.ADMIN, RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.editbook"), List.of(RoleType.ADMIN, RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.editissuancedates"), List.of(RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.edituser"), List.of(RoleType.ADMIN));
        securityDict.put(ConfigurationManager.getProperty("command.name.ratebook"), List.of(RoleType.USER));
        securityDict.put(ConfigurationManager.getProperty("command.name.updaterequeststatus"), List.of(RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.viewnotifications"), List.of(RoleType.USER));
        securityDict.put(ConfigurationManager.getProperty("command.name.userdelete"), List.of(RoleType.ADMIN));
        securityDict.put(ConfigurationManager.getProperty("command.name.viewuserinformation"), List.of(RoleType.ADMIN, RoleType.LIBRARIAN, RoleType.MODERATOR));
        securityDict.put(ConfigurationManager.getProperty("command.name.viewissuanceinformation"), List.of(RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.viewuserrequests"), List.of(RoleType.ADMIN, RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.viewuserrequestinformation"), List.of(RoleType.ADMIN, RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.viewbookinformation"), List.of(RoleType.ADMIN, RoleType.USER, RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.redirecttoaddbookpagecommand"), List.of(RoleType.ADMIN, RoleType.LIBRARIAN));
        securityDict.put(ConfigurationManager.getProperty("command.name.logout"), allRoles);
        securityDict.put(ConfigurationManager.getProperty("command.name.login"), allRoles);

    }

    public static boolean checkRoleForCommand(String commandAddress, RoleType roleToCheck) {
        if (securityDict.containsKey(commandAddress)) {
            List<RoleType>  roles = securityDict.get(commandAddress);
            return roles.contains(roleToCheck);
        }
        return false;
    }
}