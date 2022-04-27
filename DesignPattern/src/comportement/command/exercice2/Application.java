package comportement.command.exercice2;

import comportement.command.exercice1.Invoqueur;
import comportement.command.exercice2.commands.*;
import comportement.command.exercice2.entities.*;
import comportement.command.exercice2.invoquers.RemoteControl;

public class Application {
    public static void main(String[] args) {


        //create recepters, we suppose that they are unique
        TV Tv = new TV();
        SmartWindow sw = new SmartWindow();

        //create commands

        Command cmd1 = new TurnOnTvCommand(Tv);
        Command cmd2 = new TurnOffTvCommand(Tv);
        Command cmd3 = new TurnUpVolumeTvCommand(Tv);
        Command cmd4 = new TurnDownVolumeTvCommand(Tv);
        Command cmd5 = new CloseWindowCommand(sw);
        Command cmd6 = new OpenWindowCommand(sw);

        //register commands

        RemoteControl i = new RemoteControl(
                new String[]{"allumer", "eteindre", "augementer", "reduire", "ouvrir", "fermer"},
                new Command[]{cmd1, cmd2, cmd3, cmd4, cmd5, cmd6}
        );

        //tester
        i.invoque("allumer");
        i.invoque("eteindre");
        i.invoque("augementer");
        i.invoque("reduire");
        i.invoque("ouvrir");
        i.invoque("fermer");

    }
}
