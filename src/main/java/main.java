
import data.File.FileDBController;
import data.dto.UserDTO;

/**
 * @author Rasmus Sander Larsen
 */
public class main {

    public static void main(String[] args) {

        FileDBController fileDBController = new FileDBController();
        System.out.println(fileDBController.getFileDB().getFileHashMap().get(1));

        UserDTO user = new UserDTO(213123, "ALfred", "AL", "32131-1231", "password","admin");

        fileDBController.createUser(user);

        fileDBController.shutdownAndSaveToFile();
    
    }
}
