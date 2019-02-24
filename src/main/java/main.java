import TUI.TUI;
import data.File.FileDBController;
import data.dto.UserDTO;

/**
 * @author Rasmus Sander Larsen
 */
public class main {

    public static void main(String[] args) {

        FileDBController fileDBController = new FileDBController();
        System.out.println(fileDBController.getFileDB().getFileHashMap().get(1));

        UserDTO user = new UserDTO(213123, "Alfred", "AL", "32131-1231","admin");

        fileDBController.createUser(user);

        fileDBController.shutdownAndSaveToFile();
    
        TUI tui = new TUI(fileDBController);
        tui.TUI();


    }
}
