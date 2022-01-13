import view.DokterGui;
import view.LoginGui;
import view.PasienGui;
import view.RegisterPasienGui;

public class MainClass {
    public static void main(String[] args) {
        LoginGui run = new LoginGui();
        //RegisterPasienGui run = new RegisterPasienGui();
        //PasienGui run = new PasienGui(1);
        //DokterGui run = new DokterGui(1);
        run.setVisible(true);
    }
}
