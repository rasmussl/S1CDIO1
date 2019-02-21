package dal;

import data.UserList;
import data.dal.IUserDAO;
import data.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAO implements IUserDAO {
    UserList UL = new UserList();

    @Override
    public UserDTO getUser(int userId) throws DALException {
        List<UserDTO> list = UL.UserL();
        UserDTO user;

        for (int i = 0; i<list.size(); i++) {
            if (userId == list.get(i).getUserId()) {
                user = list.get(i);
                return user;
            }
        }

        return null;
    }

    @Override
    public List<UserDTO> getUserList() throws DALException {
        List<UserDTO> list = UL.UserL();
        return list;
    }

    @Override
    public void createUser(UserDTO user) throws DALException {

        UL.add(user);

    }

    @Override
    public void updateUser(UserDTO user) throws DALException {

        Scanner scan = new Scanner(System.in);

        System.out.println("Click 1 to enter, click 2 to skip");

        // ID (mabey remove it, coss wierd ID is imposible to find in getuser()
        System.out.println("Want to change User ID?");
        int choice1 = scan.nextInt();
        if (choice1 == 1) {
            System.out.println("enter the new user ID");
            int newUserID = scan.nextInt();
            user.setUserId(newUserID);
        }
        scan.nextLine();

        //User name
        System.out.println("Want to change User Name?");
        int choice2 = scan.nextInt();
        scan.nextLine();
        if (choice2 == 1) {
            System.out.println("enter the new user name");
            String newUserName = scan.nextLine();
            user.setUserName(newUserName);
        }


        //User initials
        System.out.println("Want to change initials?");
        int choice3 = scan.nextInt();
        scan.nextLine();
        if (choice3 == 1) {
            System.out.println("enter the new initials");
            String newUserIni = scan.nextLine();
            user.setIni(newUserIni);
        }

        //User CPR
        System.out.println("Want to change CPR number?");
        int choice4 = scan.nextInt();
        scan.nextLine();
        if (choice4 == 1) {
            System.out.println("enter the new CPR number");
            String newCPR = scan.nextLine();
            user.setCpr(newCPR);
        }

        //User password
        System.out.println("Want to change password?");
        int choice5 = scan.nextInt();
        scan.nextLine();
        if (choice5 == 1) {
            System.out.println("enter the new password");
            String newPassword = scan.nextLine();
            user.setPassword(newPassword);
        }

    }


    @Override
    public void deleteUser(int userId) throws DALException {

        List userList = getUserList();
        for (int i = 0; i<userList.size(); i++) {
            if (getUser(i).getUserId() == userId) {
                UL.delete(i);
            }
        }

    }







}